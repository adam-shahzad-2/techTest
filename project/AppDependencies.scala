import sbt._

object AppDependencies {
  val test = Seq(
  "org.scalatest"           %% "scalatest"               % "3.2.10",
  "org.scalatestplus"       %% "scalacheck-1-15"         % "3.2.10.0",
  "org.scalatestplus"       %% "mockito-3-4"             % "3.2.10.0"
  )

  def apply(): Seq[ModuleID] = test

}
