
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object search extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>soen 6441 project</title>
<!--	<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">-->
	<link rel="stylesheet" href=""""),_display_(/*7.32*/routes/*7.38*/.Assets.versioned("//apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css")),format.raw/*7.118*/("""">
	<script src=""""),_display_(/*8.16*/routes/*8.22*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*8.74*/(""""></script>
	<style>
		table, th, td """),format.raw/*10.17*/("""{"""),format.raw/*10.18*/("""
		  """),format.raw/*11.5*/("""border: 1px solid black;
		"""),format.raw/*12.3*/("""}"""),format.raw/*12.4*/("""
	"""),format.raw/*13.2*/("""</style>
</head>
<body>
	<div class="heading-center">
	<h1 class="heading-center" style=" text-align:center;">Welcome to Twitter search page! </h1>

		<form id="search">
	  		<center><input id="search-key" name="search-key" type="text" style=" text-align:center;width:250px; height:25px;" size="40" autocomplete="off" placeholder="Please input your key words here" /></center>
		<center><input type="submit" value="Submit"></center>
		</form>
		 <hr>
		 <h3 class="heading-center" style=" text-align:center;">This is a project for SOEN 6441 </h3>
		 <h3 class="heading-center" style=" text-align:center;">Dynamically show latest 10 tweets with search key</h3>
		 <h4 class="heading-center" style=" text-align:center;">Tianlin Yang 40010303</h4>
		 <h4 class="heading-center" style=" text-align:center;">Gaoshuo Cui  40085020</h4>
		 <h4 class="heading-center" style=" text-align:center;">Mengxuan Qiu  40082721</h4>
		 <h4 class="heading-center" style=" text-align:center;">Haitun Liao   40080732</h4>
	</div>
	<div id="search-body">


	</div>

	<script src=""""),_display_(/*36.16*/routes/*36.22*/.Assets.versioned("javascripts/search.js")),format.raw/*36.64*/(""""></script>
</body>
</html>



"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 09 15:45:00 EST 2022
                  SOURCE: /Users/haydenliao/Documents/interview/projects/Tweets Analysis System/app/views/search.scala.html
                  HASH: ebdfbc666531cb18efbc6200a7e2045084b69d03
                  MATRIX: 1031->0|1279->222|1293->228|1394->308|1438->326|1452->332|1524->384|1589->421|1618->422|1650->427|1704->454|1732->455|1761->457|2848->1517|2863->1523|2926->1565
                  LINES: 33->1|39->7|39->7|39->7|40->8|40->8|40->8|42->10|42->10|43->11|44->12|44->12|45->13|68->36|68->36|68->36
                  -- GENERATED --
              */
          