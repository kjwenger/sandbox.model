package com.u14n.sandbox.model.geography

/**
 * @author ${user.name}
 */
trait Located {
  def getCountryCode(): String
  def setCountryCode(newCountryCode: String)
  def getRegionCode(): String
  def setRegionCode(newRegionCode: String)
  def getPostalCode(): String
  def setPostalCode(newPostalCode: String)
  def getCity(): String
  def setCity(newCity: String)
  def getStreet(): String
  def setStreet(newStreet: String)
  def getNumber(): String
  def setNumber(newNumber: String)
}
