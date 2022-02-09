
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
/*1.2*/import models.UserProfileResult;

object userProfilePage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[UserProfileResult,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(userProfile: UserProfileResult):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <title> UserProfile for: ("""),_display_(/*6.36*/userProfile/*6.47*/.getUserName()),format.raw/*6.61*/(""")</title>
<!--        <link rel="stylesheet" href=""""),_display_(/*7.43*/routes/*7.49*/.Assets.versioned("stylesheets/custom.css")),format.raw/*7.92*/("""">-->
        <link rel="stylesheet" href=""""),_display_(/*8.39*/routes/*8.45*/.Assets.versioned("//apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css")),format.raw/*8.125*/("""">
        <script src=""""),_display_(/*9.23*/routes/*9.29*/.Assets.versioned("javascripts/jquery-3.3.1.min.js")),format.raw/*9.81*/(""""></script>
    </head>
    <body>
        <div style="text-align: center;">
        	<h1 style="text-align: center;">UserProfile for:  """),_display_(/*13.61*/userProfile/*13.72*/.getUserName()),format.raw/*13.86*/("""</h1>
        	"""),_display_(/*14.11*/if(userProfile.getUserImageUrl()!=null && !"".equals(userProfile.getUserImageUrl()))/*14.95*/{_display_(Seq[Any](format.raw/*14.96*/("""
        	"""),format.raw/*15.10*/("""<img src=""""),_display_(/*15.21*/userProfile/*15.32*/.getUserImageUrl()),format.raw/*15.50*/("""">
        	""")))}),format.raw/*16.11*/("""
        	"""),_display_(/*17.11*/if(userProfile.getUserId()>0)/*17.40*/{_display_(Seq[Any](format.raw/*17.41*/("""
        		"""),format.raw/*18.11*/("""<p style="text-align: center;">Id: """),_display_(/*18.47*/userProfile/*18.58*/.getUserId()),format.raw/*18.70*/("""
        	""")))}),format.raw/*19.11*/("""
        	"""),_display_(/*20.11*/if(userProfile.getUserScreenName()!=null && !"".equals(userProfile.getUserScreenName()))/*20.99*/{_display_(Seq[Any](format.raw/*20.100*/("""
        		"""),format.raw/*21.11*/("""<p style="text-align: center;">Screen Name : """),_display_(/*21.57*/userProfile/*21.68*/.getUserScreenName()),format.raw/*21.88*/("""
        	""")))}),format.raw/*22.11*/("""
        	"""),_display_(/*23.11*/if(userProfile.getUserLocation()!=null && !"".equals(userProfile.getUserLocation()))/*23.95*/{_display_(Seq[Any](format.raw/*23.96*/("""
        		"""),format.raw/*24.11*/("""<p style="text-align: center;">Location : """),_display_(/*24.54*/userProfile/*24.65*/.getUserLocation()),format.raw/*24.83*/("""
        	""")))}),format.raw/*25.11*/("""
        	"""),_display_(/*26.11*/if(userProfile.getUserDescription()!=null && !"".equals(userProfile.getUserDescription()))/*26.101*/{_display_(Seq[Any](format.raw/*26.102*/("""
        		"""),format.raw/*27.11*/("""<p style="text-align: center;">Description : """),_display_(/*27.57*/userProfile/*27.68*/.getUserDescription()),format.raw/*27.89*/("""
        	""")))}),format.raw/*28.11*/("""
        	"""),_display_(/*29.11*/if(userProfile.getUserFollowerCount()>0)/*29.51*/{_display_(Seq[Any](format.raw/*29.52*/("""
        		"""),format.raw/*30.11*/("""<p style="text-align: center;">Count : """),_display_(/*30.51*/userProfile/*30.62*/.getUserFollowerCount()),format.raw/*30.85*/("""
        	""")))}),format.raw/*31.11*/("""
        	"""),_display_(/*32.11*/if(userProfile.getUserProfileUrl()!=null && !"".equals(userProfile.getUserProfileUrl()))/*32.99*/{_display_(Seq[Any](format.raw/*32.100*/("""
        		"""),format.raw/*33.11*/("""<p style="text-align: center;">URL : """),_display_(/*33.49*/userProfile/*33.60*/.getUserProfileUrl()),format.raw/*33.80*/("""
        	""")))}),format.raw/*34.11*/("""
        	"""),_display_(/*35.11*/if(userProfile.getTimelineTweets()!=null && userProfile.getTimelineTweets().size>0)/*35.94*/{_display_(Seq[Any](format.raw/*35.95*/("""
        		"""),format.raw/*36.11*/("""<h2 style="text-align: center;">Tweets</h2>
        		"""),_display_(/*37.12*/for(index<-0 until userProfile.getTimelineTweets().size) yield /*37.68*/{_display_(Seq[Any](format.raw/*37.69*/("""
        			"""),format.raw/*38.12*/("""<p style="text-align: center;">"""),_display_(/*38.44*/userProfile/*38.55*/.getTimelineTweets().get(index)),format.raw/*38.86*/("""
        		""")))}),format.raw/*39.12*/("""
        	""")))}),format.raw/*40.11*/("""
        """),format.raw/*41.9*/("""</div>
    </body>
</html>

"""))
      }
    }
  }

  def render(userProfile:UserProfileResult): play.twirl.api.HtmlFormat.Appendable = apply(userProfile)

  def f:((UserProfileResult) => play.twirl.api.HtmlFormat.Appendable) = (userProfile) => apply(userProfile)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 09 15:45:00 EST 2022
                  SOURCE: /Users/haydenliao/Documents/interview/projects/Tweets Analysis System/app/views/userProfilePage.scala.html
                  HASH: fb0d8512ff307844b465e058fcd2563e6aa86675
                  MATRIX: 651->1|1009->35|1135->68|1254->161|1273->172|1307->186|1385->238|1399->244|1462->287|1532->331|1546->337|1647->417|1698->442|1712->448|1784->500|1948->637|1968->648|2003->662|2046->678|2139->762|2178->763|2216->773|2254->784|2274->795|2313->813|2357->826|2395->837|2433->866|2472->867|2511->878|2574->914|2594->925|2627->937|2669->948|2707->959|2804->1047|2844->1048|2883->1059|2956->1105|2976->1116|3017->1136|3059->1147|3097->1158|3190->1242|3229->1243|3268->1254|3338->1297|3358->1308|3397->1326|3439->1337|3477->1348|3577->1438|3617->1439|3656->1450|3729->1496|3749->1507|3791->1528|3833->1539|3871->1550|3920->1590|3959->1591|3998->1602|4065->1642|4085->1653|4129->1676|4171->1687|4209->1698|4306->1786|4346->1787|4385->1798|4450->1836|4470->1847|4511->1867|4553->1878|4591->1889|4683->1972|4722->1973|4761->1984|4843->2039|4915->2095|4954->2096|4994->2108|5053->2140|5073->2151|5125->2182|5168->2194|5210->2205|5246->2214
                  LINES: 24->1|29->2|34->3|37->6|37->6|37->6|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|46->15|47->16|48->17|48->17|48->17|49->18|49->18|49->18|49->18|50->19|51->20|51->20|51->20|52->21|52->21|52->21|52->21|53->22|54->23|54->23|54->23|55->24|55->24|55->24|55->24|56->25|57->26|57->26|57->26|58->27|58->27|58->27|58->27|59->28|60->29|60->29|60->29|61->30|61->30|61->30|61->30|62->31|63->32|63->32|63->32|64->33|64->33|64->33|64->33|65->34|66->35|66->35|66->35|67->36|68->37|68->37|68->37|69->38|69->38|69->38|69->38|70->39|71->40|72->41
                  -- GENERATED --
              */
          