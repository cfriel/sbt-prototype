import sbt._

class Project(info: ProjectInfo) extends DefaultProject(info)
  with ProguardProject with Exec {
  
  //project name
  override val artifactID = "myproj"

  //managed dependencies from built-in repositories
  val scalatest = "org.scalatest" % "scalatest" % "1.3"
  // val jsap = "com.martiansoftware" % "jsap" % "2.1"
  
  //files to go in packaged jars
  val extraResources = "README.md" +++ "LICENSE"
  override val mainResources = super.mainResources +++ extraResources

  //turn down logging a bit
  log.setLevel(Level.Warn)
  log.setTrace(2)

  //program entry point
  override def mainClass: Option[String] = Some("com.yuvimasory.myproj.Main")

  //compiler options
  override def compileOptions = super.compileOptions ++
    compileOptions("-deprecation", "-unchecked")
  override def javaCompileOptions =
    JavaCompileOption("-Xlint:unchecked") :: super.javaCompileOptions.toList

  //scaladoc options
  override def documentOptions =
    LinkSource ::
    documentTitle(name + " " + version + " API") ::
    windowTitle(name + " " + version + " API") ::
    Nil

  //proguard
  override def proguardOptions = List(
    "-keepclasseswithmembers " +
    "public class * { public static void main(java.lang.String[]); }",
    proguardKeepAllScala
  )
  override def proguardInJars =
    Path.fromFile(scalaLibraryJar) +++ super.proguardInJars
}
