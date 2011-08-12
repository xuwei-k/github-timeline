package github_timeline

import javax.servlet.http._

class Main extends HttpServlet {
  import Main._
  
  override def doGet( req:HttpServletRequest,  resp:HttpServletResponse){
    val o = (getRSSData \ "entry").map{ UserAction.apply }
    val oldDataIdList = DB.selectAll
    val newData = o.filterNot{a => oldDataIdList.contains(a.id)}
    DB.insert(newData:_*)
    val client = TweetClient(Settings.TwitterBotSetting)
    newData.foreach{ Thread.sleep(500) ; client.tweet }
  }
}

object Main{
  
  private val MyGithubRSS = new java.net.URL( 
    """https://github.com/timeline."""
  )
  
  def getRSSData:xml.Elem = {
    xml.XML.load(MyGithubRSS)
  }
  
}
