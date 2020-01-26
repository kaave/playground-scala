name := "scala-test-2020"
organization := "io.github.kaave"
version := "0.1"
scalaVersion := "2.13.1"
scalacOptions ++= Seq(
  // show detail warning when use deprecated API
  "-deprecation",
  // show detail warning when use features like "trap"
  "-feature",
  "-language:implicitConversions",
  "-Ywarn-unused:imports"
)
Compile / console / scalacOptions -= "-Ywarn-unused:imports"
// libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.4.2"
// // test library
// libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
// // mock
// libraryDependencies += "org.mockito" % "mockito-core" % "2.28.2" % Test
// lint not tests and sbt console
wartremoverErrors in (Compile, compile) ++= Warts.unsafe
