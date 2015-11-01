package com.u14n.sandbox.model;

import java.util.Collections;
import java.util.List;

public interface DAOProtocol<T, U> {
	/**
	 * @param t
	 * @throws DAOException
	 */
	default T insert(T t) throws DAOException {
		return t;
	}

	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	default T findById(final U id) throws DAOException {
		/* trace */ System.out.println("DAOProtocol.findById() id.hashCode()=" + id.hashCode());
		List<T> all = findAll();
		/* trace */ System.out.println("DAOProtocol.findById() all.size()=" + all.size());
		return all.stream()
				.filter(t -> {
					/* trace */ System.out.println("DAOProtocol.findById() findAll().stream().filter() t.hashCode()=" + t.hashCode());
					return t.hashCode() == id.hashCode(); })
				.findFirst()
				.orElseThrow(() -> all.isEmpty()
					? new DAOException(
						new RuntimeException(
							String.format("Not found id %d in %d",
								id.hashCode(), all.size())))
					: new DAOException(
						new RuntimeException(
							String.format("Not found id %d", id.hashCode()),
							new RuntimeException("Empty"))));
	}

	/**
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	default List<T> findByName(final String name) throws DAOException {
		return Collections.emptyList();
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
}
