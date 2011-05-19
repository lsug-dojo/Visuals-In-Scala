import sbt._
import spde._
import de.element34.sbteclipsify._

class Project(info: ProjectInfo) extends DefaultSpdeProject(info) with Eclipsify 
  with extract.BasicSelfExtractingProject   // not needed after extraction
  with LocalLauncherProject                 // ditto
{
  /** Tasks to run after extraction, not needed after */
  override def installActions = update.name :: sbtScript.name :: "run" :: Nil
   val scalatest = "org.junit" % "junit" % "4.8.1"
}
