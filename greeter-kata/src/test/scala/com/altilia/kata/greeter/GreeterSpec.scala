package com.altilia.kata.greeter

import java.util.Calendar
import java.util.logging.{Level, Logger}

import com.altilia.kata.greeter.core.Greeter
import com.altilia.kata.greeter.rule.{GoodEveningRule, GoodMorningRule, GoodNightRule, Rule}
import org.mockito.Mockito._
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfter, FunSuite}


class GreeterSpec extends FunSuite with BeforeAndAfter with MockitoSugar {

  var greeter : Greeter = _
  var calendar : Calendar = _
  val logger = Logger.getLogger("Greeter")

  before {
    calendar = mock[Calendar]
    val rules = List[Rule] (new GoodMorningRule, new GoodEveningRule, new GoodNightRule)
    greeter = new Greeter(calendar, rules, logger)
  }


  test("greet function that receives a name as input and outputs Hello name") {
    for(i <- 12 to 17) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Hello Fabrizio" == greeter.greet("Fabrizio"))
    }
  }

  test("greet function trims the input") {
    for(i <- 12 to 17) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Hello Fabrizio" == greeter.greet("     Fabrizio     "))
    }
  }

  test("greet function capitalizes the first letter of the name") {
    for(i <- 12 to 17) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Hello Fabrizio" == greeter.greet("     fabrizio     "))
    }
  }

  test("greet function return good morning name when the time is 6-12") {
    for (i <- 6 to 11) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Good morning Fabrizio" == greeter.greet("Fabrizio"))
    }
  }

  test("greet function return good evening name when the time is 18-22") {
    for (i <- 18 to 21) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Good evening Fabrizio" == greeter.greet("Fabrizio"))
    }
  }

  test("greet function return good night name when the time is 22-06") {
    for (i <- 22 to 23) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Good night Fabrizio" == greeter.greet("Fabrizio"))
    }
    for (i <- 0 to 5) {
      when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(i)
      assert("Good night Fabrizio" == greeter.greet("Fabrizio"))
    }
  }
}
