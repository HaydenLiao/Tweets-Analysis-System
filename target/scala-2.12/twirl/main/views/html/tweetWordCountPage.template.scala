
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
/*1.2*/import models.TweetDistinctWordCountResult;

object tweetWordCountPage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[TweetDistinctWordCountResult,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(wordCount : TweetDistinctWordCountResult):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <title>TweetMiner - WordCount("""),_display_(/*7.40*/wordCount/*7.49*/.getSearchKey()),format.raw/*7.64*/(""")</title>
        <link rel="stylesheet" href=""""),_display_(/*8.39*/routes/*8.45*/.Assets.versioned("//apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css")),format.raw/*8.125*/("""">
        <script src=""""),_display_(/*9.23*/routes/*9.29*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*9.81*/(""""></script>
    </head>
    <body>
        <div style=" text-align:center;">
        	<h1>Distinct Word Count For: """),_display_(/*13.40*/wordCount/*13.49*/.getSearchKey()),format.raw/*13.64*/("""</h1>
        	</div>
			      	<table class="table table-stripped table-color" border="12" align="center">
						<thead>
							<tr>
								<th column="word-column">Word</th>
								<th column="word-column">Count</th>
							</tr>
						</thead>
						<tbody>
						 """),_display_(/*23.9*/if(wordCount.getDistinctWordsCount() != null)/*23.54*/{_display_(Seq[Any](format.raw/*23.55*/("""
						 """),_display_(/*24.9*/for((key,value) <- wordCount.getDistinctWordsCount()) yield /*24.62*/{_display_(Seq[Any](format.raw/*24.63*/("""
							"""),format.raw/*25.8*/("""<tr >
								<td>"""),_display_(/*26.14*/key),format.raw/*26.17*/("""</td>
								<td>"""),_display_(/*27.14*/value),format.raw/*27.19*/("""</td>
							</tr>
							""")))}),format.raw/*29.9*/("""
							""")))}),format.raw/*30.9*/("""
					"""),format.raw/*31.6*/("""</table>
			      </div>
        </div>
    </body>
</html>

"""))
      }
    }
  }

  def render(wordCount:TweetDistinctWordCountResult): play.twirl.api.HtmlFormat.Appendable = apply(wordCount)

  def f:((TweetDistinctWordCountResult) => play.twirl.api.HtmlFormat.Appendable) = (wordCount) => apply(wordCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 09 15:45:00 EST 2022
                  SOURCE: /Users/haydenliao/Documents/interview/projects/Tweets Analysis System/app/views/tweetWordCountPage.scala.html
                  HASH: b30e081a512bf945fead10924c13494aa0162498
                  MATRIX: 651->1|1034->46|1170->89|1197->90|1320->187|1337->196|1372->211|1446->259|1460->265|1561->345|1612->370|1626->376|1698->428|1841->544|1859->553|1895->568|2192->839|2246->884|2285->885|2320->894|2389->947|2428->948|2463->956|2509->975|2533->978|2579->997|2605->1002|2662->1029|2701->1038|2734->1044
                  LINES: 24->1|29->2|34->3|35->4|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|44->13|44->13|44->13|54->23|54->23|54->23|55->24|55->24|55->24|56->25|57->26|57->26|58->27|58->27|60->29|61->30|62->31
                  -- GENERATED --
              */
          