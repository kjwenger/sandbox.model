package com.u14n.sandbox.model.geography

import scala.beans.BeanProperty

import javax.xml.bind.annotation.XmlRootElement

import javax.persistence.Entity
import javax.persistence.Id

import java.util.Optional

import com.u14n.sandbox.model.Constants
import com.u14n.sandbox.model.Identifiable
import com.u14n.sandbox.model.Revisionable

/**
 * @author ${user.name}
 */
@XmlRootElement
@Entity
class Location(
  @BeanProperty var countryCode: String,
  @BeanProperty var regionCode: String,
  @BeanProperty var postalCode: String,
  @BeanProperty var city: String,
  @BeanProperty var street: String,
  @BeanProperty var number: String)
    extends Object
    with Located
    with Identifiable.ByHash
    with Revisionable[Integer]
    with Equals {
  var revision: Integer = -1

  def this() {
    this(Constants.STRING_EMPTY,
        Constants.STRING_EMPTY,
        Constants.STRING_EMPTY,
        Constants.STRING_EMPTY,
        Constants.STRING_EMPTY,
        Constants.STRING_EMPTY)
  }
  def this(that: Location) {
    this(that.countryCode,
      that.regionCode,
      that.postalCode,
      that.city,
      that.street,
      that.number)
  }

  // Expose the ID
  @Id
  override def getId() = super.getId()
  @Id
  override def setId(id) { super.setId(id) }

  override def getRevision(): Integer = revision
  override def setRevision(newRevision: Integer) { revision = newRevision }

  def canEqual(other: Any) = {
    other.isInstanceOf[com.u14n.sandbox.model.geography.Location]
  }

  override def equals(other: Any) = {
    other match {
      case that: com.u14n.sandbox.model.geography.Location =>
        that.canEqual(Location.this) &&
          this.countryCode == that.countryCode &&
          this.regionCode == that.regionCode &&
          this.postalCode == that.postalCode &&
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
            (prime *
              (prime +
                  countryCode.hashCode) +
                regionCode.hashCode) +
              postalCode.hashCode) +
            city.hashCode) +
          street.hashCode) +
        number.hashCode
  }

  override def toString(): String = {
    return new StringBuilder()
      .append(countryCode).append(Constants.STRING_COMMA)
      .append(regionCode ).append(Constants.STRING_COMMA)
      .append(postalCode ).append(Constants.STRING_COMMA)
      .append(city       ).append(Constants.STRING_COMMA)
      .append(street     ).append(Constants.STRING_COMMA)
      .append(number)
      .toString();
  }
}
