package implementations;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import interfaces.UserProfile;
import models.UserProfileResult;
import play.libs.Json;
import services.TwitterAPItools;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Print the user profile with latest 10 tweets
 * @author Tianlin Yang
 * @version 1.1
 */
public class UserProfilePrint implements UserProfile {
	/**
	 * Get all the profile information
	 * @author Tianlin Yang
	 * @param searchKey Keyword
	 * @param count Target number
	 * @return Returns list of user profile information
	 */

	@Override
	public UserProfileResult  getUserProfile(String searchKey, int count) {
		UserProfileResult profileResult = new UserProfileResult();
		//Initialize user profile twitter
		Twitter twitter = TwitterAPItools.twitterObject.geTwitterInstance();
		//Initialize space for saving temp
		List<Status> tempTweets = new ArrayList<Status>();
		ArrayNode userProfile = Json.newArray();
		try {
			User user = twitter.showUser(searchKey);
			Paging paging = new Paging();
			paging.setCount(count);
			tempTweets = twitter.getUserTimeline(user.getId(),paging);
			StringBuilder stringBuilder = new StringBuilder();
			List<String> timelineTweetsList = new ArrayList<String>();
			if(tempTweets!=null && tempTweets.size()>0)
			{
				tempTweets.forEach(t->{
					timelineTweetsList.add(t.getText());
				});
			}
			profileResult.setTimelineTweets(timelineTweetsList);
			profileResult.setUserDescription(user.getDescription());
			profileResult.setUserFollowerCount(user.getFollowersCount());
			profileResult.setUserId(user.getId());
			profileResult.setUserImageUrl(user.getBiggerProfileImageURL());
			profileResult.setUserIsProtected(user.isProtected());
			profileResult.setUserLocation(user.getLocation());
			profileResult.setUserName(user.getName());
			profileResult.setUserProfileUrl(user.getURL());
			profileResult.setUserScreenName(user.getScreenName());

		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profileResult;//Return all formatted profile text.
	}
	//Fake Json info used for test case
	static String FakeJson = "{\n" +
			"  \"in_reply_to_status_id_str\": null,\n" +
			"  \"in_reply_to_status_id\": null,\n" +
			"  \"coordinates\": null,\n" +
			"  \"created_at\": \"Wed Oct 22 18:05:19 +0000 2014\",\n" +
			"  \"truncated\": false,\n" +
			"  \"in_reply_to_user_id_str\": null,\n" +
			"  \"source\": \"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\n" +
			"  \"retweeted_status\": {\n" +
			"    \"in_reply_to_status_id_str\": null,\n" +
			"    \"in_reply_to_status_id\": null,\n" +
			"    \"coordinates\": null,\n" +
			"    \"created_at\": \"Wed Oct 22 17:58:08 +0000 2014\",\n" +
			"    \"truncated\": false,\n" +
			"    \"in_reply_to_user_id_str\": null,\n" +
			"    \"source\": \"<a href=\\\"http://itunes.apple.com/us/app/twitter/id409789998?mt=12\\\" rel=\\\"nofollow\\\">Twitter for Mac</a>\",\n" +
			"    \"retweet_count\": 6,\n" +
			"    \"retweeted\": false,\n" +
			"    \"geo\": null,\n" +
			"    \"in_reply_to_screen_name\": null,\n" +
			"    \"entities\": {\n" +
			"      \"urls\": [],\n" +
			"      \"hashtags\": [\n" +
			"        {\n" +
			"          \"indices\": [\n" +
			"            91,\n" +
			"            101\n" +
			"          ],\n" +
			"          \"text\": \"Microsoft\"\n" +
			"        },\n" +
			"        {\n" +
			"          \"indices\": [\n" +
			"            102,\n" +
			"            110\n" +
			"          ],\n" +
			"          \"text\": \"Windows\"\n" +
			"        },\n" +
			"        {\n" +
			"          \"indices\": [\n" +
			"            129,\n" +
			"            140\n" +
			"          ],\n" +
			"          \"text\": \"LeyZamudio\"\n" +
			"        }\n" +
			"      ],\n" +
			"      \"user_mentions\": [\n" +
			"        {\n" +
			"          \"indices\": [\n" +
			"            46,\n" +
			"            52\n" +
			"          ],\n" +
			"          \"screen_name\": \"Corfo\",\n" +
			"          \"id_str\": \"57015564\",\n" +
			"          \"name\": \"Corfo\",\n" +
			"          \"id\": 57015564\n" +
			"        }\n" +
			"      ],\n" +
			"      \"symbols\": []\n" +
			"    },\n" +
			"    \"id_str\": \"524983055652360192\",\n" +
			"    \"in_reply_to_user_id\": null,\n" +
			"    \"favorite_count\": 4,\n" +
			"    \"id\": 524983055652360200,\n" +
			"    \"text\": \"El Chileno tiene derecho a postular a capital @Corfo Pero q NO te dejen postular x NO usar #Microsoft #Windows es Discriminación #LeyZamudio\",\n" +
			"    \"place\": null,\n" +
			"    \"contributors\": null,\n" +
			"    \"lang\": \"es\",\n" +
			"    \"user\": {\n" +
			"      \"utc_offset\": null,\n" +
			"      \"friends_count\": 780,\n" +
			"      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/492125365293568000/qsIuWYjP_normal.jpeg\",\n" +
			"      \"listed_count\": 34,\n" +
			"      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme14/bg.gif\",\n" +
			"      \"default_profile_image\": false,\n" +
			"      \"favourites_count\": 135,\n" +
			"      \"description\": \"Músico & Geek; Marido & Papá. Co-Fundador & Director Ejecutivo de @pantalla_cl; stay hungry, stay foolish (Steve Jobs -June 2005)\",\n" +
			"      \"created_at\": \"Tue Mar 11 12:53:02 +0000 2008\",\n" +
			"      \"is_translator\": false,\n" +
			"      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme14/bg.gif\",\n" +
			"      \"protected\": false,\n" +
			"      \"screen_name\": \"andresreitze\",\n" +
			"      \"id_str\": \"14122556\",\n" +
			"      \"profile_link_color\": \"009999\",\n" +
			"      \"is_translation_enabled\": false,\n" +
			"      \"id\": 14122556,\n" +
			"      \"geo_enabled\": true,\n" +
			"      \"profile_background_color\": \"131516\",\n" +
			"      \"lang\": \"es\",\n" +
			"      \"profile_sidebar_border_color\": \"EEEEEE\",\n" +
			"      \"profile_location\": null,\n" +
			"      \"profile_text_color\": \"333333\",\n" +
			"      \"verified\": false,\n" +
			"      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/492125365293568000/qsIuWYjP_normal.jpeg\",\n" +
			"      \"time_zone\": null,\n" +
			"      \"url\": \"http://t.co/IodqmRZoS7\",\n" +
			"      \"contributors_enabled\": false,\n" +
			"      \"profile_background_tile\": true,\n" +
			"      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/14122556/1398980661\",\n" +
			"      \"entities\": {\n" +
			"        \"description\": {\n" +
			"          \"urls\": []\n" +
			"        },\n" +
			"        \"url\": {\n" +
			"          \"urls\": [\n" +
			"            {\n" +
			"              \"display_url\": \"facebook.com/Pantalla.cl\",\n" +
			"              \"indices\": [\n" +
			"                0,\n" +
			"                22\n" +
			"              ],\n" +
			"              \"expanded_url\": \"http://www.facebook.com/Pantalla.cl\",\n" +
			"              \"url\": \"http://t.co/IodqmRZoS7\"\n" +
			"            }\n" +
			"          ]\n" +
			"        }\n" +
			"      },\n" +
			"      \"statuses_count\": 26786,\n" +
			"      \"follow_request_sent\": false,\n" +
			"      \"followers_count\": 1269,\n" +
			"      \"profile_use_background_image\": true,\n" +
			"      \"default_profile\": false,\n" +
			"      \"following\": false,\n" +
			"      \"name\": \"Andrés Reitze\",\n" +
			"      \"location\": \"Santiago, Chile\",\n" +
			"      \"profile_sidebar_fill_color\": \"EFEFEF\",\n" +
			"      \"notifications\": false\n" +
			"    },\n" +
			"    \"favorited\": false\n" +
			"  },\n" +
			"  \"retweet_count\": 6,\n" +
			"  \"retweeted\": false,\n" +
			"  \"geo\": null,\n" +
			"  \"in_reply_to_screen_name\": null,\n" +
			"  \"entities\": {\n" +
			"    \"urls\": [],\n" +
			"    \"hashtags\": [\n" +
			"      {\n" +
			"        \"indices\": [\n" +
			"          109,\n" +
			"          119\n" +
			"        ],\n" +
			"        \"text\": \"Microsoft\"\n" +
			"      },\n" +
			"      {\n" +
			"        \"indices\": [\n" +
			"          120,\n" +
			"          128\n" +
			"        ],\n" +
			"        \"text\": \"Windows\"\n" +
			"      },\n" +
			"      {\n" +
			"        \"indices\": [\n" +
			"          139,\n" +
			"          140\n" +
			"        ],\n" +
			"        \"text\": \"LeyZamudio\"\n" +
			"      }\n" +
			"    ],\n" +
			"    \"user_mentions\": [\n" +
			"      {\n" +
			"        \"indices\": [\n" +
			"          3,\n" +
			"          16\n" +
			"        ],\n" +
			"        \"screen_name\": \"andresreitze\",\n" +
			"        \"id_str\": \"14122556\",\n" +
			"        \"name\": \"Andrés Reitze\",\n" +
			"        \"id\": 14122556\n" +
			"      },\n" +
			"      {\n" +
			"        \"indices\": [\n" +
			"          64,\n" +
			"          70\n" +
			"        ],\n" +
			"        \"screen_name\": \"Corfo\",\n" +
			"        \"id_str\": \"57015564\",\n" +
			"        \"name\": \"Corfo\",\n" +
			"        \"id\": 57015564\n" +
			"      }\n" +
			"    ],\n" +
			"    \"symbols\": []\n" +
			"  },\n" +
			"  \"id_str\": \"524984861342564352\",\n" +
			"  \"in_reply_to_user_id\": null,\n" +
			"  \"favorite_count\": 0,\n" +
			"  \"id\": 524984861342564350,\n" +
			"  \"text\": \"RT @andresreitze: El Chileno tiene derecho a postular a capital @Corfo Pero q NO te dejen postular x NO usar #Microsoft #Windows es Discrim…\",\n" +
			"  \"place\": null,\n" +
			"  \"contributors\": null,\n" +
			"  \"lang\": \"es\",\n" +
			"  \"user\": {\n" +
			"    \"utc_offset\": -10800,\n" +
			"    \"friends_count\": 1419,\n" +
			"    \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/458940469443952641/k4W4RMkF_normal.jpeg\",\n" +
			"    \"listed_count\": 5,\n" +
			"    \"profile_background_image_url\": \"http://pbs.twimg.com/profile_background_images/83201515/TWITTER.jpg\",\n" +
			"    \"default_profile_image\": false,\n" +
			"    \"favourites_count\": 7,\n" +
			"    \"description\": \"\",\n" +
			"    \"created_at\": \"Thu Jan 21 20:37:37 +0000 2010\",\n" +
			"    \"is_translator\": false,\n" +
			"    \"profile_background_image_url_https\": \"https://pbs.twimg.com/profile_background_images/83201515/TWITTER.jpg\",\n" +
			"    \"protected\": false,\n" +
			"    \"screen_name\": \"estebanmmp\",\n" +
			"    \"id_str\": \"107197310\",\n" +
			"    \"profile_link_color\": \"009999\",\n" +
			"    \"is_translation_enabled\": false,\n" +
			"    \"id\": 107197310,\n" +
			"    \"geo_enabled\": true,\n" +
			"    \"profile_background_color\": \"131516\",\n" +
			"    \"lang\": \"es\",\n" +
			"    \"profile_sidebar_border_color\": \"EEEEEE\",\n" +
			"    \"profile_location\": null,\n" +
			"    \"profile_text_color\": \"333333\",\n" +
			"    \"verified\": false,\n" +
			"    \"profile_image_url\": \"http://pbs.twimg.com/profile_images/458940469443952641/k4W4RMkF_normal.jpeg\",\n" +
			"    \"time_zone\": \"Santiago\",\n" +
			"    \"url\": null,\n" +
			"    \"contributors_enabled\": false,\n" +
			"    \"profile_background_tile\": false,\n" +
			"    \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/107197310/1398254745\",\n" +
			"    \"entities\": {\n" +
			"      \"description\": {\n" +
			"        \"urls\": []\n" +
			"      }\n" +
			"    },\n" +
			"    \"statuses_count\": 2354,\n" +
			"    \"follow_request_sent\": false,\n" +
			"    \"followers_count\": 390,\n" +
			"    \"profile_use_background_image\": true,\n" +
			"    \"default_profile\": false,\n" +
			"    \"following\": false,\n" +
			"    \"name\": \"ESTEBAN MMP\",\n" +
			"    \"location\": \"viña del mar, chile\",\n" +
			"    \"profile_sidebar_fill_color\": \"EFEFEF\",\n" +
			"    \"notifications\": false\n" +
			"  },\n" +
			"  \"favorited\": false\n" +
			"}";
}
