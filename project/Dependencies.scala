
import sbt._
object Dependencies {
  val scalaRequests = "com.lihaoyi" %% "requests" % "0.5.1"
  val scalaXml = "org.scala-lang.modules" %% "scala-xml" % "1.2.0"
  val scalaTest = "org.scalatest" %% "scalatest" % "3.1.1"

  val commonDependencies: Seq[ModuleID] = Seq(scalaTest % Test)

  val apiDependencies: Seq[ModuleID] = Seq(scalaRequests, scalaXml) ++ commonDependencies

  val calculatorDependencies: Seq[ModuleID] = commonDependencies

  val scalaOptions: Seq[String] = Seq ("-deprecation", "-feature")
}
