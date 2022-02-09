
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
/*1.2*/import models.TweetsResult;

object hashTagPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[TweetsResult,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(tweets: TweetsResult):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>

<html lang="en" class="no-js">
    <head>
        <title>HashTag ("""),_display_(/*7.26*/tweets/*7.32*/.getSearchKey()),format.raw/*7.47*/(""")</title>
        <link rel="stylesheet" href=""""),_display_(/*8.39*/routes/*8.45*/.Assets.versioned("//apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css")),format.raw/*8.125*/("""">
        <script src=""""),_display_(/*9.23*/routes/*9.29*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*9.81*/(""""></script>
        <style>
		table, th, td """),format.raw/*11.17*/("""{"""),format.raw/*11.18*/("""
		  """),format.raw/*12.5*/("""border: 1px solid black;
		"""),format.raw/*13.3*/("""}"""),format.raw/*13.4*/("""
	    """),format.raw/*14.6*/("""</style>
    </head>
    <div class="heading-center">
    <h1 class="heading-center" style=" text-align:center;">HashTag ("""),_display_(/*17.70*/tweets/*17.76*/.getSearchKey()),format.raw/*17.91*/(""")</h1>
    <form id="search">
	  		<center><input id="search-key" name="search-key" type="text" value = """"),_display_(/*19.77*/tweets/*19.83*/.getSearchKey()),format.raw/*19.98*/("""" style=" text-align:center;width:250px; height:25px;" size="40" autocomplete="on"/></center>
	<center><input type="submit" value="SEARCH"></center>
	</form>
	<div id="search-body">
	</div>
    <script src=""""),_display_(/*24.19*/routes/*24.25*/.Assets.versioned("javascripts/search.js")),format.raw/*24.67*/(""""></script>
        <script type="text/javascript">
        $("#search").submit()
        </script>
</html>

"""))
      }
    }
  }

  def render(tweets:TweetsResult): play.twirl.api.HtmlFormat.Appendable = apply(tweets)

  def f:((TweetsResult) => play.twirl.api.HtmlFormat.Appendable) = (tweets) => apply(tweets)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 09 15:45:00 EST 2022
                  SOURCE: /Users/haydenliao/Documents/interview/projects/Tweets Analysis System/app/views/hashTagPage.scala.html
                  HASH: 10fd0e6d3afd6cef8fc998369b48336d0e2ba17b
                  MATRIX: 651->1|995->30|1111->53|1221->137|1235->143|1270->158|1344->206|1358->212|1459->292|1510->317|1524->323|1596->375|1668->419|1697->420|1729->425|1783->452|1811->453|1844->459|1994->582|2009->588|2045->603|2178->709|2193->715|2229->730|2464->938|2479->944|2542->986
                  LINES: 24->1|29->2|34->3|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|42->11|42->11|43->12|44->13|44->13|45->14|48->17|48->17|48->17|50->19|50->19|50->19|55->24|55->24|55->24
                  -- GENERATED --
              */
          