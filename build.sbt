name := "Akka-Http-Dynamo-POC"

version := "0.1"

scalaVersion := "2.11.8"

libraryDependencies ++= {
  val loggerVersion = "1.7.25"
  val amazonDbVersion = "1.11.341"

  Seq("com.amazonaws" % "aws-java-sdk-dynamodb" % amazonDbVersion,
    "com.amazonaws" % "aws-java-sdk-test-utils" % amazonDbVersion % Test,
    "org.slf4j" % "slf4j-api" % loggerVersion,
    "org.slf4j" % "slf4j-simple" % "1.7.25")
}

libraryDependencies ++= {
  val akkaV = "2.5.3"
  val akkaHttpV = "10.0.9"
  val scalaTestV = "3.0.1"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaV,
    "com.typesafe.akka" %% "akka-stream" % akkaV,
    "com.typesafe.akka" %% "akka-testkit" % akkaV,
    "com.typesafe.akka" %% "akka-http" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpV,
    "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpV,
    "org.scalatest" %% "scalatest" % scalaTestV % "test",
    "org.json4s" %% "json4s-native" % "3.6.0-M3",
    "org.json4s" %% "json4s-ast" % "3.6.0-M3",
    "com.typesafe.akka" %% "akka-http-spray-json" % "10.0.5"
  )
}
