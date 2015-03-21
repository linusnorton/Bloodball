name := "Bloodball"

version := "1.0"

scalaVersion := "2.11.4"
libraryDependencies ++= Seq(
  "org.scalatest" % "scalatest_2.11" % "2.2.2" % "test"
)

scalaSource in Test <<= (baseDirectory in Test)(_ / "test")

scalaSource in Compile <<= (baseDirectory in Compile)(_ / "src")

fork in console := true