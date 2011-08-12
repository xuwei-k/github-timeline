package github_timeline

object DB{
  import com.google.appengine.api.datastore._
  import scala.collection.JavaConversions._
  
  private val propertyName = "id"
    
  private val EntityKind = "github-timeline"
    
  val ds = DatastoreServiceFactory.getDatastoreService
  
  def insert(actions:UserAction*){
    val d = new java.util.Date
    actions.foreach{c =>
      val e = new Entity(EntityKind)
      e.setProperty(propertyName, c.id )
      e.setProperty("insert-date", d )
      ds.put(e)
    }
  }
    
  def selectAll:Seq[UserActionID] = {
    ds.prepare(new Query(EntityKind)).asIterable.map{
      _.getProperty(propertyName).asInstanceOf[String]
    }.toSeq
  }

}
