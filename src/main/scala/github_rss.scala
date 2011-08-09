
package object github_rss {
  @inline def allCatchPrintStackTrace(body: => Any){
    try{
      val r = body
    }catch{
      case e:Exception => e.printStackTrace
    }
  }
  
  type UserActionID = String
}