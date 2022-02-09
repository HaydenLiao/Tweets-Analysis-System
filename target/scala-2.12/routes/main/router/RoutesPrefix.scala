// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/haydenliao/Documents/interview/projects/Tweets Analysis System/conf/routes
// @DATE:Wed Feb 09 15:45:00 EST 2022


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
