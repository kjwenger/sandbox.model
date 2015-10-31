package com.u14n.sandbox.model

import org.junit.Before
import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SimpleSuite extends FunSuite {

  test("should not pend") (pending)
  
  ignore("should not be ignored") {
    assert(1 === 2)
  }

  test("should test") {
    assert(1 === 1)
  }

  test("should also test") {
    assert(1 == 1.0)
  }

}