package com.u14n.sandbox.model;

import java.util.Collections;
import java.util.List;

public interface DAOProtocol<T, U> {
	/**
	 * @param t
	 * @throws DAOException
	 */
	default T insert(final T t) throws DAOException {
		return t;
	}

	/**
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	default T findById(U id) throws DAOException {
		return null;
	}

	/**
	 * @param name
	 * @return
	 * @throws DAOException
	 */
	default List<T> findByName(String name) throws DAOException {
		return Collections.emptyList();
	}

	/**
	 * @return
	 * @throws DAOException
	 */
	default List<T> findAll() throws DAOException {
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
