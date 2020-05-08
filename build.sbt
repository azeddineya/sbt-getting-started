import com.typesafe.sbt.packager.docker.ExecCmd
import sbt.Keys.libraryDependencies

name := "sbt-getting-started"

version := "0.1"

scalaVersion := "2.13.2"
//lazy val root = project.in(file("."))
//  .aggregate(calculators)

lazy val calculators = project
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .dependsOn(api)
  .settings(
    scalacOptions ++= Dependencies.scalaOptions,
    libraryDependencies ++= Dependencies.calculatorDependencies,
    dockerCommands := dockerCommands.value.filterNot {
      case ExecCmd("ENTRYPOINT", _) => true
      case _ => false
    },
    dockerCommands ++= Seq(ExecCmd("ENTRYPOINT", "/opt/docker/bin/net-worth"))
  )


lazy val api = project
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    scalacOptions ++= Dependencies.scalaOptions,
    libraryDependencies ++=Dependencies.apiDependencies,

  )

