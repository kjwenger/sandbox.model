package com.u14n.sandbox.model;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public interface DAOProtocol<T, U> {
	/**
	 * @param t
	 * @throws DAOException
	 */
	default T insert(T t) throws DAOException {
		return t;
	}

	/**
	 * @param identity
	 * @return
	 * @throws DAOException
	 */
	default T findByIdentity(final U identity) throws DAOException {
		/* trace */ System.out.println("DAOProtocol.findByIdentity() identity.hashCode()=" + identity.hashCode());
		List<T> all = findAll();
		/* trace */ System.out.println("DAOProtocol.findByIdentity() all.size()=" + all.size());
		return all.stream()
				.filter(t -> {
					/* trace */ System.out.println("DAOProtocol.findByIdentity() findAll().stream().filter() t.hashCode()=" + t.hashCode());
					return t.hashCode() == identity.hashCode(); })
				.findFirst()
				.orElseThrow(() -> all.isEmpty()
					? new DAOException(
						new RuntimeException(
							String.format("Not found identity %d in %d",
								identity.hashCode(), all.size())))
					: new DAOException(
						new RuntimeException(
							String.format("Not found identity %d", identity.hashCode()),
							new RuntimeException("Empty"))));
	}

	/**
	 * @return
	 * @throws DAOException
	 */
	default List<T> findAll() throws DAOException {
		/* trace */ System.out.println("DAOProtocol.findAll()");
		return Collections.emptyList();
	}

	/**
	 * @param t
	 * @throws DAOException
	 */
	default T update(T t) throws DAOException {
		return t;
	}

	/**
	 * @param t
	 * @throws DAOException
	 */
	default T delete(T t) throws DAOException {
		return t;
	}

	static class ConcurrentMemory<T, U> implements DAOProtocol<T, U> {
		private CopyOnWriteArrayList<T> list = new CopyOnWriteArrayList<T>();

		/**
		 * @param t
		 * @throws DAOException
		 */
		@Override
		public T insert(T t) throws DAOException {
			if (list.addIfAbsent(t)) {
				return t;
			}
			throw new DAOException(
					new RuntimeException("Cannot insert over existing"));
		}
		/**
		 * @return
		 * @throws DAOException
		 */
		@Override
		public List<T> findAll() throws DAOException {
			return list;
			
		}
		/**
		 * @param t
		 * @throws DAOException
		 */
		@Override
		public T update(T t) throws DAOException {
			if (list.contains(t)) {
				return t;
			}
			throw new DAOException(
					new RuntimeException("Cannot update non-existing"));
		}
		/**
		 * @param t
		 * @throws DAOException
		 */
		@Override
		public T delete(T t) throws DAOException {
			if (list.remove(t)) {
				return t;
			}
			throw new DAOException(
					new RuntimeException("Cannot remove non-existing"));
		}
	}
}
