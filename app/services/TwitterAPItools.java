/**
 * 
 */
package services;

import java.util.List;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.inject.Guice;
import com.google.inject.Injector;

import implementations.*;
import models.TweetDistinctWordCountResult;
import models.TweetsResult;
import models.UserProfileResult;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * This class is to implement data fetch operations from twitter API.
 * @author Mengxuan Qiu
 * @version 1.0
 */
public class TwitterAPItools {
	public static boolean isTesting = false;
	public static String typeOfFake = "";
	/**
	 * guice - A object of type Injector
	 */
	public static Injector guice = Guice.createInjector(new TwitterModule());
	/**
	 * twitterObject - A object of type ReturnTwitterObject
	 */
	public static ReturnTwitterObject twitterObject = guice.getInstance(ReturnTwitterObject.class);

	
	/**
	 * Fetches tweets based on search(key) asynchronously
	 * @author Mengxuan Qiu
	 * @param searchKey A variable of type string
	 * @param count A variable of type int
	 * @return tweets based on search(key)
	 * @throws TwitterException
	 */
	public static ArrayNode getTweets(String searchKey,int count, int countEmotion) throws TwitterException {
		return new GetTenTweets().getTweetsAsync(searchKey, count);
	}
	
	/**
	 * @author Gaoshuo Cui
	 * @param searchKey A variable of type String.
	 * @param count A variable of type int.
	 * @return emotion based on searchKey.
	 * @throws TwitterException
	 */
	public static ArrayNode getTweetsEmotion(String searchKey,int count) throws TwitterException{
		return new TweetSentimentDetermine().getTweetSentiment(searchKey, count);
	}
	
	/**
	 * @author Mengxuan Qiu
	 * @param searchKey A variable of type String
	 * @param count A variable of type int
	 * @return tweet's based on hashtag.
	 * @throws TwitterException
	 */
	public static TweetsResult getHashTagTweets(String searchKey,int count) throws TwitterException {
		return new HashTagTweetsImpl().getHashTweets(searchKey,count);
	}
	
	/**
	 * @author Mengxuan Qiu
	 * @param searchKey A variable of type String
	 * @param count A variable of type int
	 * @return distinct words based on serachKey
	 * @throws TwitterException
	 */
	public static TweetDistinctWordCountResult getTweetDistinctWordCount(String searchKey,int count) throws TwitterException {
		return new DistinctWordDescending().getTweetDistinctWordCount(searchKey, count);
	}
	

	
	/**
	 * @author Tianlin Yang
	 * @param userName A variable of type String
	 * @param count A variable of type int
	 * @return the profile of the user
	 * @throws TwitterException
	 */
	public static UserProfileResult getUserProfile(String userName,int count) throws TwitterException {
		return new UserProfilePrint().getUserProfile(userName, count);
	}
}
