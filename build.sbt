// Settings file for all the modules.
import xml.Group
import sbt._
import Keys._
import Defaults._

organization := "__foursquare_shaded__.io.swagger"

version := "1.0.6-fs0"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-reflect" % scalaVersion.value exclude("com.google.guava", "guava"),
  "org.scalatest" %% "scalatest" % "3.0.8" % "test" exclude("com.google.guava", "guava"),
  "junit" % "junit" % "4.12" % "test" exclude("com.google.guava", "guava"),
)

// NOTE(ssoman): If re-patching, you will need to drop copies of our shaded jackson jar, jackson-module-scala jar
// and shaded swagger jar into the repo's top-level 'lib' directory for sbt to find them.
unmanagedBase := file("lib")

resolvers in ThisBuild ++= Seq(
  Resolver.mavenLocal,
  Resolver.typesafeRepo("releases"),
  Resolver.typesafeRepo("snapshots"),
  Resolver.sonatypeRepo("releases"),
  Resolver.sonatypeRepo("snapshots")
)
