name := "dotty-resolve-test"

ThisBuild / scalaVersion := "2.12.7"

libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.14.0" % "test"

testOptions in Test += Tests.Argument(TestFrameworks.ScalaCheck, "-maxSize", "5", "-minSuccessfulTests", "33", "-workers", "1", "-verbosity", "1")
