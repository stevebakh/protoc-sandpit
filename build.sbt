name := "protoc-sandpit"

organization := "substrate"

version      := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.3"

libraryDependencies ++= Seq(
  "io.grpc" % "grpc-netty" % "1.10.0",
  "com.thesamet.scalapb" %% "scalapb-runtime-grpc" % "0.7.0")

PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value)
