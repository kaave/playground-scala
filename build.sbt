lazy val root = (project in file(".")).settings(
    name := "PlaygroundScala",
    organization := "io.github.kaave",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.12.8",
    scalacOptions ++= Seq(
        // show detail warning when use deprecated API
        "-deprecation",
        // show detail warning when use features like "trap"
        "-feature",
        "-language:implicitConversions",
        "-Ywarn-unused:imports"
    ),
    Compile / console / scalacOptions -= "-Ywarn-unused:imports",
    libraryDependencies += "org.scalaj" %% "scalaj-http" % "2.3.0",
    wartremoverErrors ++= Warts.unsafe
  )