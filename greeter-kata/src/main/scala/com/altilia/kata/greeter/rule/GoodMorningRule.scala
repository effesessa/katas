package com.altilia.kata.greeter.rule

class GoodMorningRule extends Rule {

  private final val GOOD_MORNING = "Good morning "

  override def belongsToThisRange(hour: Integer): Boolean = hour >=6 && hour < 12

  override def getMessage: String = GOOD_MORNING
}
