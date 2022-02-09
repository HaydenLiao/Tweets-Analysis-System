package implementations;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import interfaces.TweetSentiment;
import play.libs.Json;
import services.TwitterAPItools;
import twitter4j.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * This class is implementing the functionality of determining sentiment of the tweets(happy,sad or neutral).
 * @author Gaoshuo Cui
 * @version 1.0
 * @see interfaces.TweetSentiment
 */
public class TweetSentimentDetermine implements TweetSentiment {
	/**
	 * If a tweet contains more than 70% “happy” strings, return a happy emoticon :-),
	 * for more than 70% sad, return an unhappy emoticon :-(,
	 * otherwise a neutral one :-|
	 * @author Gaoshuo Cui
	 * @param searchKey string type of key word
	 * @param count An int of number of tweets.
	 * @return String type of emoticon
	 * @throws TwitterException, ExecutionException,InterruptedException
	 * @see interfaces.HappyCount
	 * @see interfaces.SadCount
	 */

	@Override
	public ArrayNode getTweetSentiment(String searchKey, int count) {
		Query ourQuery = new Query(searchKey);//represents search query from tweet4j
		ourQuery.count(count);//Sets the number of tweets to return per page
		Twitter twitter = TwitterAPItools.twitterObject.geTwitterInstance();//get the twitter object
		String resultFacial="";//initial
		ArrayNode node = Json.newArray();
        //try catch
		try {
			QueryResult result = twitter.search(ourQuery); //representing search API response
			List<Status> listTweets = result.getTweets();//Get tweets
			long totalSize = listTweets.size();//total size
			//Asynchronously get the number of words that are happy or not
			CompletableFuture<String> sentimentFuture = CompletableFuture.supplyAsync(()->new SentimentCount().getHappyCount(listTweets))
							.thenCombine
							(CompletableFuture.supplyAsync(()->new SentimentCount().getSadCount(listTweets)),
							(i,j)->{
								if ((i*100.0)/totalSize>=70) { return ":-)";
									  //If happy words account for 70% of the total number
									}else if ((j*100.0)/totalSize>=70) {//else if sad words account for 70% of the total number
								    return ":-("; }else { return ":-|";//else neutral sentiment
									}
							});
			resultFacial = sentimentFuture.get();//get the final sentiment
			ObjectNode n = Json.newObject();
			n.put("TweetEmotion", resultFacial);
			node.add(n);
		}catch (TwitterException | InterruptedException | ExecutionException exception) {
		// TODO Auto-generated catch block
		exception.printStackTrace();
	 }
		return node;
	}

}
