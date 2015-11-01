package com.u14n.sandbox.model

trait Identified[U] extends Identifiable[U] {
  var id: U = _

  override def getIdentifier(): U = id
}