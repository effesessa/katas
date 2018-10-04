name := "greeter-kata"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.mockito" % "mockito-core" % "2.11",
  "com.typesafe.scala-logging" %% "scala-logging-slf4j" % "2.1.2",
  "com.typesafe" %% "scalalogging-slf4j" % "1.0.1",
  "org.slf4j" % "slf4j-jdk14" % "1.7.25",
  "ch.qos.logback" % "logback-classic" % "1.0.3"
)
