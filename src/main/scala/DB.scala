package github_rss

object DB{
  import com.google.appengine.api.datastore._
  import scala.collection.JavaConversions._
  
  private val propertyName = "id"
    
  private val EntityKind = "xuwei_k-followee"
    
  val ds = DatastoreServiceFactory.getDatastoreService
  
  def insert(actions:UserAction*){
    actions.foreach{c =>
      val e = new Entity(EntityKind)
      e.setProperty(propertyName, c.id )
      ds.put(e)
    }
  }
    
  def selectAll:Seq[UserActionID] = {
    ds.prepare(new Query(EntityKind)).asIterable.map{
      _.getProperty(propertyName).asInstanceOf[String]
    }.toSeq
  }

}