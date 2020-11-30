ThisBuild / scalaVersion := "2.12.10"

lazy val root = project.in(file(".")).aggregate(parser.js, parser.jvm)

lazy val parser = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(
    name := "simple-arithmetic-parser",
    version := "0.1",
    libraryDependencies ++= Seq(
      "com.lihaoyi" %%% "fastparse" % "2.2.4",
      "com.chuusai" %%% "shapeless" % "2.4.0-M1",
      "org.scalactic" %%% "scalactic" % "3.2.2",
      "org.scalatest" %%% "scalatest" % "3.3.0-SNAP2" % Test
    )
  ).
  jsSettings(
    scalaJSUseMainModuleInitializer := true,
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "1.1.0",
      "com.lihaoyi" %%% "scalatags" % "0.9.2"
    )
  ).
  jvmSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %% "scalajs-stubs" % "1.0.0" % "provided"
    )
  )
