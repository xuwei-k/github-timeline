import sbt._
import Keys._

object BuildGAE extends Build{

  val twitter4jRepository = "twitter4jRepository" at "http://twitter4j.org/maven2" 

  val twitter4jVersion = "2.2.4"

  val gaeSDK = "1.5.2"

  val apacheHttp = "4.1.2"

  lazy val example = Project("web", file("."),
    settings = {
      Defaults.defaultSettings ++ 
      sbtappengine.AppenginePlugin.webSettings ++ 
      Seq(
        scalaVersion := "2.9.0-1", 
        libraryDependencies ++= Seq(
           "org.twitter4j" % "twitter4j-appengine" % twitter4jVersion 
          ,"javax.servlet" % "servlet-api" % "2.5"
          ,"org.twitter4j" % "twitter4j-httpclient-support" % twitter4jVersion
          ,"org.twitter4j" % "twitter4j-core" % twitter4jVersion
          ,"org.twitter4j" % "twitter4j-examples" % twitter4jVersion
          ,"org.apache.httpcomponents" % "httpcore" % apacheHttp
          ,"org.apache.httpcomponents" % "httpcomponents-client" % apacheHttp 
          ,"com.google.appengine" % "appengine-java-sdk" % gaeSDK 
          ,"com.google.appengine" % "appengine-api-1.0-sdk" % gaeSDK 
          ,"org.apache.httpcomponents" % "httpmime" % apacheHttp
          ,"net.kindleit" % "gae-runtime" % gaeSDK 
          ,"org.scalaj"  %% "scalaj-http" % "0.2.8"  
        )
      )
    }
  )
}
