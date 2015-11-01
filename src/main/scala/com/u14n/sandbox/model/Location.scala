package com.u14n.sandbox.model

import scala.beans.BeanProperty

/**
 * @author ${user.name}
 */
class Location (@BeanProperty var zipCode: String)
    extends (Object)
    with Equals {
  def this() {
    this("")
  }

  def canEqual(that: Any) = {
    that.isInstanceOf[com.u14n.sandbox.model.Location]
  }

  override def equals(that: Any) = {
    that match {
      case that: com.u14n.sandbox.model.Location =>
        that.canEqual(Location.this) && zipCode == that.zipCode
      case _ => false
    }
  }

  override def hashCode() = {
    val prime = 41
    prime + zipCode.hashCode
  }
}
