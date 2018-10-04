package com.altilia.kata.greeter.utils

object FormatterName {

  def format(name : String): String = capitalize(trim(name))

  def trim(name : String): String = name.trim

  def capitalize(name: String): String = name.capitalize
}
