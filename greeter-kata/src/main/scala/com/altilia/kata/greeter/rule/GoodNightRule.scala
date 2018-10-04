package com.altilia.kata.greeter.rule

class GoodNightRule extends  Rule{

  private final val GOOD_NIGHT = "Good night "

  override def belongsToThisRange(hour: Integer): Boolean = (hour >= 22 && hour < 24) || (hour >= 0 && hour < 6)

  override def getMessage: String = GOOD_NIGHT
}
