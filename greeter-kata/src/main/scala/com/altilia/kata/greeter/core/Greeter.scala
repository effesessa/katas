package com.altilia.kata.greeter.core

import java.util.Calendar
import java.util.logging.{Level, Logger}

import com.altilia.kata.greeter.rule.Rule
import com.altilia.kata.greeter.utils.FormatterName

class Greeter(calendar: Calendar, rules : List[Rule], logger: Logger) {

  private final val HELLO = "Hello "

  def greet(name: String): String = {
    logger.log(Level.INFO, "greet method called with name " + name)
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    val message = rules.filter(_.belongsToThisRange(hour)).map(_.getMessage).headOption
    message.getOrElse(HELLO) + format(name)
  }

  private def format(name: String): String = FormatterName.format(name)
}

