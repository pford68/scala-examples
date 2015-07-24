package com.macedon.scala.examples.basic

import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._

class ExampleTest {

  @Test
  def first: Unit = {
    assertEquals(2 + 2, 4)
  }

  @Test
  def second: Unit = {
    assertTrue(2 + 2 == 4)
  }

}
