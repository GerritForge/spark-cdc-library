name := "spark-cdc"

version := "1.1.1"

organization := "com.gerritforge"

scalaVersion := "2.10.4"

val sparkVersion = "1.3.1"

val sparkCore = "org.apache.spark" %% "spark-core" % sparkVersion
val sparkSql = "org.apache.spark" %% "spark-sql" % sparkVersion
val sparkCsv = "org.apache.spark" %% "spark-csv" % sparkVersion
val commonsIo = "commons-io"              %  "commons-io"           % "2.4"

resolvers ++= Seq(
  Resolver.sonatypeRepo("release"),
  Resolver.sonatypeRepo("public"),
  Resolver.mavenLocal,
  "Typesafe Releases" at "http://repo.typesafe.com/typesafe/maven-releases/"
)

libraryDependencies ++=
  ( Seq( sparkCore, sparkSql ) map { _ % "provided" } ) ++
  Seq(
    "org.scalatest" %% "scalatest" % "2.2.4" % "test",
    commonsIo
  )

// Errors creating spark contexts otherwise
parallelExecution in Test := false
