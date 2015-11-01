package com.u14n.sandbox.model

trait LocationDAO extends DAOTrait[Location, Long] {

}

object LocationDAO {
  class ConcurrentMemory
      extends DAOTrait.ConcurrentMemory[Location, Long]
      with LocationDAO {

  }
}