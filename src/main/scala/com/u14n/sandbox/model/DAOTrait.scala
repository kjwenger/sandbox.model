package com.u14n.sandbox.model

import java.util.List
import java.util.Collection
import java.util.Collections
import java.util.concurrent.CopyOnWriteArrayList
import java.lang.RuntimeException

/**
 * @author Klaus Wenger
 *
 * @param <T> The model type to be accessed
 * @param <U> The type of the unique key
 */
trait DAOTrait[T, U] extends DAOProtocol[T, U] {
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  override def insert(t: T): T = { return t }
  /**
   * @return
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  override def findAll(): List[T] = { return Collections.emptyList[T] }
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  override def update(t: T): T = { return t }
  /**
   * @param t
   * @throws DAOException
   */
  @throws(classOf[DAOException])
  override def delete(t: T): T = { return t }
}

object DAOTrait {
  class ConcurrentMemory[T, U] extends DAOTrait[T, U] {
    var list: CopyOnWriteArrayList[T] = new CopyOnWriteArrayList[T];

    /**
     * @param t
     * @throws DAOException
     */
    @throws(classOf[DAOException])
    override def insert(t: T): T = {
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
    @throws(classOf[DAOException])
    override def findAll(): List[T] = list
    /**
     * @param t
     * @throws DAOException
     */
    @throws(classOf[DAOException])
    override def update(t: T): T = { 
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
    @throws(classOf[DAOException])
    override def delete(t: T): T = {
      if (list.remove(t)) {
        return t;
      }
      throw new DAOException(
        new RuntimeException("Cannot remove non-existing"));
    }
  }
}