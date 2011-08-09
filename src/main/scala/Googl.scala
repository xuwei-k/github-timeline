package github_rss

object Googl{
  import scalaj.http._
  import scala.util.parsing.json.JSON
  
  def getShortUrl(longUrl:String):String = {
    try{
      val data = 
        Http.postData("https://www.googleapis.com/urlshortener/v1/url",
        """{ "longUrl" :  "%s" }""".format(longUrl)    
        ).header("Content-Type","application/json").asString

      JSON.parseFull(data).get.asInstanceOf[scala.collection.Map[String,String]].apply("id")
    }catch{
      case e:Exception => e.printStackTrace
      longUrl
    }
  }
}
