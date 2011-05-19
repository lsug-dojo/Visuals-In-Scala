import sbt._

class Plugins(info: ProjectInfo) extends PluginDefinition(info) 
{
  val databinder_repo = "Databinder Repository" at "http://databinder.net/repo"
	val spde_sbt = "us.technically.spde" % "spde-sbt-plugin" % "0.4.2"
	val extract = "org.scala-tools.sbt" % "installer-plugin" % "0.3.0"
    lazy val eclipse = "de.element34" % "sbt-eclipsify" % "0.7.0"
}
