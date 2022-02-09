// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/haydenliao/Documents/interview/projects/Tweets Analysis System/conf/routes
// @DATE:Wed Feb 09 15:45:00 EST 2022

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:20
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:20
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseTotalController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def searchTweetDistinctWordCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.searchTweetDistinctWordCount",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTweetWordCount/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
    // @LINE:17
    def searchTweetsByHashTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.searchTweetsByHashTag",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getHashTagTweets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
    // @LINE:8
    def socket: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.socket",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "connectWebSocket"})
        }
      """
    )
  
    // @LINE:14
    def getUserProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.getUserProfile",
      """
        function(userName0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUserProfile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("userName", userName0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:10
    def getTweetsEmotion: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TotalController.getTweetsEmotion",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getTweetsEmotion/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
  }


}
