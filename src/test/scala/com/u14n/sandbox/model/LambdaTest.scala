package com.u14n.sandbox.model

import org.junit.Test
import java.util.ArrayList
import java.util.Arrays

class LambdaTest {

  @Test
  def shouldStream() {
    val list = new ArrayList[Int](Arrays.asList(1, 2, 3, 4))
    assert(list.size == 4)
    val multiplier = { e: Int => e * 2 }
// http://scala-lang.org/news/2.11.1
/// A new experimental way of compiling closures, implemented by @JamesIry. With -Ydelambdafy:method anonymous functions are compiled faster, with a smaller bytecode footprint. This works by keeping the function body as a private (static, if no this reference is needed) method of the enclosing class, and at the last moment during compilation emitting a small anonymous class that extends FunctionN and delegates to it. This sets the scene for a smooth migration to Java 8-style lambdas (not yet implemented).     */
//    val mapped = list.stream().map(multiplier)
  }
}