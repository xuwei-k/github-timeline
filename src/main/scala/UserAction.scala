package github_timeline

case class UserAction(
  id:UserActionID,
  url:String,
  title:String
) {
  
  def tweetString:String = {
    (Googl.getShortUrl(url) + " " + title).take(140).replace("@"," ").replace("#"," ")
  }
}

object UserAction{  
  def apply(rawData:xml.Node):UserAction = {
    UserAction(
      (rawData \ "id").text,
      (rawData \\ "@href").text,
      (rawData \ "title").text
    )
  }
}
