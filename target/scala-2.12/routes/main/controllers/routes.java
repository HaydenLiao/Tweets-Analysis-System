// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/haydenliao/Documents/interview/projects/Tweets Analysis System/conf/routes
// @DATE:Wed Feb 09 15:45:00 EST 2022

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseTotalController TotalController = new controllers.ReverseTotalController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseTotalController TotalController = new controllers.javascript.ReverseTotalController(RoutesPrefix.byNamePrefix());
  }

}
