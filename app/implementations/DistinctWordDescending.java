package implementations;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import interfaces.TweetDistictWord;
import models.TweetDistinctWordCountResult;
import play.libs.Json;
import services.TwitterAPItools;
import twitter4j.*;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * TaskB display 250 tweets as word-level in descending order.
 * @author Mengxuan Qiu
 * @version 1.0
 * @see interfaces.TweetDistictWord
 */
public class DistinctWordDescending implements TweetDistictWord{

	/**
	 * Counting all the unique words and display the word-count in descending order
	 * @author Mengxuan Qiu
	 * @param searchKey Search keyword
	 * @param count Number of tweet's
	 * @return distinctWordJson ArrayList
	 *         in format {word=count}
	 */

	@Override
	public TweetDistinctWordCountResult getTweetDistinctWordCount(String searchKey, int count) {
		TweetDistinctWordCountResult countResult = new TweetDistinctWordCountResult();
		countResult.setSearchKey(searchKey);
		Twitter twitter = TwitterAPItools.twitterObject.geTwitterInstance();
		Query query = new Query(searchKey);
		query.count(count);
		List<Status> tweetsStatus = new ArrayList<Status>();
		try {
			QueryResult queryResult = twitter.search(query);
			tweetsStatus = queryResult.getTweets(); } catch (TwitterException e) { e.printStackTrace();
		}
		ArrayNode distinctWordJsonList = Json.newArray();
		/**
		 * build a map to store the distinct word and its number
		 */
		Map <String, Integer > WordMap =tweetsStatus.stream()
												.map(tweetS->tweetS.getText())
												.map(sent->sent.split(" "))
//				                                 .distinct()
												.flatMap(Arrays::stream)
//
												.map(s->s.toLowerCase())

												.collect(toMap(token ->token , num -> 1, (key1,key2) ->key1.intValue()+1 ));
//		List <String> context= tweetsStatus.stream().map(tweet->tweet.getText())
//											.map(sent->sent.split(" "))
//											.flatMap(Arrays::stream)
//											.map(s->s.toLowerCase()).collect(toList());
		/**
		 * print the map when it is called
		 */
//		context.stream().forEach(e->{System.out.println(e);});
		Map <String, Integer > wordCounterSorted = WordMap.entrySet().stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
						.thenComparing(Map.Entry.<String, Integer>comparingByKey().reversed()))
				.collect(Collectors.toMap(Map.Entry::getKey , Map.Entry::getValue, (e1,e2)-> e2, LinkedHashMap::new));
		wordCounterSorted.entrySet().stream().forEach(e->{System.out.println(e.getValue() + " " + e.getKey());});
		countResult.setDistinctWordsCount(wordCounterSorted);
		return countResult;
	}

}
