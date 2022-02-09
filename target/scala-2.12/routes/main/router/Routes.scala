// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/haydenliao/Documents/interview/projects/Tweets Analysis System/conf/routes
// @DATE:Wed Feb 09 15:45:00 EST 2022

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  TotalController_0: controllers.TotalController,
  // @LINE:20
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    TotalController_0: controllers.TotalController,
    // @LINE:20
    Assets_1: controllers.Assets
  ) = this(errorHandler, TotalController_0, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TotalController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.TotalController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """connectWebSocket""", """controllers.TotalController.socket()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTweetsEmotion/""" + "$" + """searchKey<[^/]+>""", """controllers.TotalController.getTweetsEmotion(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getTweetWordCount/""" + "$" + """searchKey<[^/]+>""", """controllers.TotalController.searchTweetDistinctWordCount(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUserProfile/""" + "$" + """userName<[^/]+>""", """controllers.TotalController.getUserProfile(userName:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getHashTagTweets/""" + "$" + """searchKey<[^/]+>""", """controllers.TotalController.searchTweetsByHashTag(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_TotalController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_TotalController_index0_invoker = createInvoker(
    TotalController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_TotalController_socket1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("connectWebSocket")))
  )
  private[this] lazy val controllers_TotalController_socket1_invoker = createInvoker(
    TotalController_0.socket(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "socket",
      Nil,
      "GET",
      this.prefix + """connectWebSocket""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_TotalController_getTweetsEmotion2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTweetsEmotion/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TotalController_getTweetsEmotion2_invoker = createInvoker(
    TotalController_0.getTweetsEmotion(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "getTweetsEmotion",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getTweetsEmotion/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_TotalController_searchTweetDistinctWordCount3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getTweetWordCount/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TotalController_searchTweetDistinctWordCount3_invoker = createInvoker(
    TotalController_0.searchTweetDistinctWordCount(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "searchTweetDistinctWordCount",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getTweetWordCount/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_TotalController_getUserProfile4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUserProfile/"), DynamicPart("userName", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TotalController_getUserProfile4_invoker = createInvoker(
    TotalController_0.getUserProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "getUserProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getUserProfile/""" + "$" + """userName<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_TotalController_searchTweetsByHashTag5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getHashTagTweets/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TotalController_searchTweetsByHashTag5_invoker = createInvoker(
    TotalController_0.searchTweetsByHashTag(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TotalController",
      "searchTweetsByHashTag",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getHashTagTweets/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:20
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_TotalController_index0_route(params@_) =>
      call { 
        controllers_TotalController_index0_invoker.call(TotalController_0.index())
      }
  
    // @LINE:8
    case controllers_TotalController_socket1_route(params@_) =>
      call { 
        controllers_TotalController_socket1_invoker.call(TotalController_0.socket())
      }
  
    // @LINE:10
    case controllers_TotalController_getTweetsEmotion2_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_TotalController_getTweetsEmotion2_invoker.call(TotalController_0.getTweetsEmotion(searchKey))
      }
  
    // @LINE:12
    case controllers_TotalController_searchTweetDistinctWordCount3_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_TotalController_searchTweetDistinctWordCount3_invoker.call(TotalController_0.searchTweetDistinctWordCount(searchKey))
      }
  
    // @LINE:14
    case controllers_TotalController_getUserProfile4_route(params@_) =>
      call(params.fromPath[String]("userName", None)) { (userName) =>
        controllers_TotalController_getUserProfile4_invoker.call(TotalController_0.getUserProfile(userName))
      }
  
    // @LINE:17
    case controllers_TotalController_searchTweetsByHashTag5_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_TotalController_searchTweetsByHashTag5_invoker.call(TotalController_0.searchTweetsByHashTag(searchKey))
      }
  
    // @LINE:20
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
