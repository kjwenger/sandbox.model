package com.u14n.sandbox.model

import scala.beans.BeanProperty

/**
 * @author ${user.name}
 */
class Location(
  @BeanProperty var countryCode: String, 
  @BeanProperty var regionCode: String, 
  @BeanProperty var zipCode: String, 
  @BeanProperty var city: String, 
  @BeanProperty var street: String)
    extends Object
    with Identifiable[Integer]
    with Revisionable[Integer]
    with Equals {
  var revision: Int = -1

  def this() {
    this("", "", "", "", "")
  }
  def this(that: Location) {
    this(that.countryCode,
      that.regionCode,
      that.zipCode,
      that.city,
      that.street)
  }

  override def getIdentifier(): Integer = hashCode()

  override def getRevision(): Integer = revision
  override def setRevision(newRevision: Integer) { revision = newRevision }

  def canEqual(other: Any) = {
    other.isInstanceOf[com.u14n.sandbox.model.Location]
  }

  override def equals(other: Any) = {
    other match {
      case that: com.u14n.sandbox.model.Location =>
        that.canEqual(Location.this) &&
        this.countryCode == that.countryCode &&
        this.regionCode == that.regionCode &&
        this.zipCode == that.zipCode &&
        this.city == that.city &&
        this.street == that.street
      case _ => false
    }
  }

  override def hashCode() = {
    val prime = 41
    prime *
      (prime *
        (prime *
          (prime *
            (prime + countryCode.hashCode) +
              regionCode.hashCode) +
            zipCode.hashCode) +
          city.hashCode) +
        street.hashCode
  }
}
