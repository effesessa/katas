package com.altilia.kata.greeter.rule

class GoodEveningRule extends  Rule {

  private final val GOOD_EVENING = "Good evening "

  override def belongsToThisRange(hour: Integer): Boolean = hour >=18 && hour < 22

  override def getMessage: String = GOOD_EVENING
}
