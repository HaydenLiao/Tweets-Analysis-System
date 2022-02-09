// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/haydenliao/Documents/interview/projects/Tweets Analysis System/conf/routes
// @DATE:Wed Feb 09 15:45:00 EST 2022

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:20
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:6
  class ReverseTotalController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def searchTweetDistinctWordCount(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getTweetWordCount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
    // @LINE:17
    def searchTweetsByHashTag(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getHashTagTweets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
    // @LINE:8
    def socket(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "connectWebSocket")
    }
  
    // @LINE:14
    def getUserProfile(userName:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUserProfile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("userName", userName)))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
    // @LINE:10
    def getTweetsEmotion(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getTweetsEmotion/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
  }


}
