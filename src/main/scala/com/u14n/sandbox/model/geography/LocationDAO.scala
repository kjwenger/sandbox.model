package com.u14n.sandbox.model.geography

import com.u14n.sandbox.model.DAOTrait

trait LocationDAO extends DAOTrait[Location, Long] {
  override def findByIdentity(identity): Location = {
                                                                                System.out.println("LocationDAO.findByIdentity() identity=" + identity)
    val all = findAll()
//    val daoException = new DAOException(
//      new RuntimeException(
//        String.format("Not found identity %d in %d",
//          identity.getId(), all.size())))
                                                                                System.out.println("LocationDAO.findByIdentity() all.size()=" + all.size())
    return all.stream()
        .filter(t => {
                                                                                System.out.println("LocationDAO.findByIdentity() findAll().stream().filter() t.getId()=" + t.getId())
          return t.getId() == identity })
        .findFirst()
        .get()
//        .orElseThrow((): Unit => DAOException)
  }
}

object LocationDAO {
  class ConcurrentMemory
      extends DAOTrait.ConcurrentMemory[Location, Long]
      with LocationDAO {

  }
}