
package object github_timeline {
  @inline def allCatchPrintStackTrace(body: => Any){
    try{
      val r = body
    }catch{
      case e:Exception => e.printStackTrace
    }
  }
  
  type UserActionID = String
}
