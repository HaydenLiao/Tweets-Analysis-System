package implementations;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import interfaces.HashTagTweetsSearch;
import models.TweetsResult;
import services.TwitterAPItools;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;


/**
 * Implements functionality of fetching Tweet's by hash tag
 * @author Haitun Liao
 * @version 1.0
 * @see interfaces.HashTagTweetsSearch
 *
 */
public class HashTagTweetsImpl implements HashTagTweetsSearch{

	/**
	 * Get 10 latest tweet's from a hash tag asynchronously
	 *  @author Haitun Liao
	 *  @param searchKey of type String
	 *  @param count of tweet
	 *  @return TweetsResult
	 */

	@Override
	public TweetsResult getHashTweets(String searchKey, int count) {
		TweetsResult tweetResult = new TweetsResult();
		tweetResult.setSearchKey(searchKey);
		Twitter twitter = TwitterAPItools.twitterObject.geTwitterInstance();
		Query query = new Query(searchKey);
		query.count(count);
		List<Status> tweetsStatus = new ArrayList<Status>();
		try {
			QueryResult queryResult = twitter.search(query);
			tweetsStatus = queryResult.getTweets(); } catch (TwitterException e) {e.printStackTrace();
		}
		List<String> result = tweetsStatus.stream()
								.map(status -> status.getText())
								.collect(toList());
		tweetResult.setTweets(result);
		return tweetResult;
	}

}
