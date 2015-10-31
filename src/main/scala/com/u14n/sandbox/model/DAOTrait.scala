package com.u14n.sandbox.model

import java.util.List
import java.util.Collections

/**
 * @author Klaus Wenger
 *
 * @param <T> The model type to be accessed
 * @param <U> The type of the unique key
 */
trait DAOTrait[T, U] {
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def insert(t: T) {}
  /**
   * @param id
   * @return
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def findById(id: U): List[T] = Collections.emptyList[T]
  /**
   * @param name
   * @return
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def findByName(name: String): List[T] = Collections.emptyList[T]
  /**
   * @return
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def findAll(): List[T] = Collections.emptyList[T]
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def update(t: T) {}
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  def delete(t: T) {}
}