package github_timeline

import twitter4j._
import twitter4j.conf._

case class TweetClient(p:BotSettings) {
  
  val t = {
    val c = new ConfigurationBuilder
      c.setDebugEnabled(true)
      .setOAuthConsumerKey(p.consumerKey)
      .setOAuthConsumerSecret(p.consumerSecret)
      .setOAuthAccessToken(p.accessToken)
      .setOAuthAccessTokenSecret(p.accessTokenSecret);
      
     new TwitterFactory(c.build()).getInstance()
  }
  
  def tweet(a:UserAction){
    allCatchPrintStackTrace{
      t.updateStatus(a.tweetString)
    }
  }
  
}

case class BotSettings(
    consumerKey:String,
    consumerSecret:String,
    accessToken:String,
    accessTokenSecret:String
){}

