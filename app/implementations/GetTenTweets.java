package implementations;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import interfaces.SearchTweets;
import play.libs.Json;
import services.TwitterAPItools;
import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toList;

/**
 * Retrieves 10 most recent tweet's for each of search phrases(single or multiple)
 *  provided as input 
 * @author Mengxuan Qiu
 * @version 1.0
 * @see interfaces.SearchTweets
 */
public class GetTenTweets implements SearchTweets{
	/**
	 * Return a list of 10 most recent tweets that include the search phrase asynchronously in the form of jsonObject(jsonNode).
	 * @author Mengxuan Qiu
	 * @param searchKey Search keyword 
	 * @param count Number of Tweet's 
	 */

	@Override
	public ArrayNode getTweetsAsync(String searchKey, int count) {
		Twitter twitter = TwitterAPItools.twitterObject.geTwitterInstance();
		Query query = new Query(searchKey);
		query.count(count);
		List<Status> tweetsStatus = new ArrayList<Status>();
		try {
			QueryResult queryResult = twitter.search(query);
			tweetsStatus = queryResult.getTweets(); } catch (TwitterException e) { e.printStackTrace(); }
		ArrayNode tweets = Json.newArray();
		List<CompletableFuture<ObjectNode>> nodesFuture = tweetsStatus.stream()
										.map(status -> CompletableFuture.supplyAsync(()->new JsonConverter().convertTweetToJson(status)))
										.collect(toList());
		
		List<ObjectNode> nodes = nodesFuture.stream().map(CompletableFuture::join)
												.collect(toList());
		nodes.forEach(node->tweets.add(node));
		return tweets;
	}
	
}
