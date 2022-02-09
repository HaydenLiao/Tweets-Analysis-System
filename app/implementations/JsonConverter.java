package implementations;

import com.fasterxml.jackson.databind.node.ObjectNode;
import interfaces.TweetToJson;
import play.libs.Json;
import twitter4j.HashtagEntity;
import twitter4j.Status;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Transform the tweets object to into json object.
 * @author Mengxuan Qiu
 * @version 1.0
 * @see JsonConverter
 */
public class JsonConverter implements TweetToJson{
	 /**
     * An action that converts data to JSON format.
     * @author Mengxuan Qiu
     * @return ObjectNode
     */

	@Override
	public ObjectNode convertTweetToJson(Status tweetStatus) {
		ObjectNode node = Json.newObject();
		node.put("name", tweetStatus.getUser().getName());
		node.put("displayName", tweetStatus.getUser().getScreenName());
		node.put("tweet", tweetStatus.getText());
		node.put("location", tweetStatus.getUser().getLocation());
		node.put("latitude", "");
		node.put("longitude", "");
		node.put("showLocationLink", false);
//		if(tweetStatus.getGeoLocation()!=null) {
//			node.put("latitude", tweetStatus.getGeoLocation().getLatitude());
//			node.put("longitude", tweetStatus.getGeoLocation().getLongitude());
//			node.put("showLocationLink", true);
//		}
		
		HashtagEntity[] hashTags = tweetStatus.getHashtagEntities();
		String hashTag = Arrays.stream(hashTags)
								.map(hashT->hashT.getText())
								.distinct()
								.collect(Collectors.joining(","));
		node.put("hashTags", hashTag);
		return node;
	}
	
}
