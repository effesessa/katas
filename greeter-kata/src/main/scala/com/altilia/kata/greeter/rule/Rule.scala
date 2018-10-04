package com.altilia.kata.greeter.rule

trait Rule {

  def belongsToThisRange(hour : Integer) : Boolean

  def getMessage : String
}
