lazy val root = project
  .in(file("."))
  .settings(
    name := "dotty-resolve-samples",
    description := "Dotty samples with compilation tests",
    version := "0.1.0",

    scalaVersion := "0.11.0-RC1"
  )
