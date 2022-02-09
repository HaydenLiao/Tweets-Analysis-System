import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementations.TweetSentimentDetermine;
import models.TweetsResult;
import org.assertj.core.api.Assertions;
import org.junit.BeforeClass;
import org.junit.Test;

import implementations.SentimentCount;
import twitter4j.*;

/**
 * This class is testing the functionality behind determining the count of sentiment of the tweets.
 * @author Gaoshuo Cui
 * @version 1.0
 *
 */
public class SentimentCountTest {

	public static List<Status> listTweet;

	//This method is taking the status of user and testing it for sad and happy or neutral emoticons.

	@BeforeClass
	public static void setup() {

		listTweet = new ArrayList<Status>();
		Status sadSentiment = new Status() {
			
			@Override
			public UserMentionEntity[] getUserMentionEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URLEntity[] getURLEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public SymbolEntity[] getSymbolEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MediaEntity[] getMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HashtagEntity[] getHashtagEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ExtendedMediaEntity[] getExtendedMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RateLimitStatus getRateLimitStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getAccessLevel() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int compareTo(Status o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean isTruncated() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweetedByMe() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweeted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweet() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isPossiblySensitive() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFavorited() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String[] getWithheldInCountries() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public User getUser() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return ":-(";
			}
			
			@Override
			public String getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Scopes getScopes() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Status getRetweetedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getRetweetCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getQuotedStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Status getQuotedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Place getPlace() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLang() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getInReplyToUserId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getInReplyToStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getInReplyToScreenName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public GeoLocation getGeoLocation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getFavoriteCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getCurrentUserRetweetId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Date getCreatedAt() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long[] getContributors() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		//happy sentiment
		Status happySentiment = new Status() {
			
			@Override
			public UserMentionEntity[] getUserMentionEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URLEntity[] getURLEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public SymbolEntity[] getSymbolEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MediaEntity[] getMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HashtagEntity[] getHashtagEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ExtendedMediaEntity[] getExtendedMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RateLimitStatus getRateLimitStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getAccessLevel() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int compareTo(Status o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean isTruncated() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweetedByMe() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweeted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweet() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isPossiblySensitive() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFavorited() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String[] getWithheldInCountries() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public User getUser() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return ":-)";
			}
			
			@Override
			public String getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Scopes getScopes() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Status getRetweetedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getRetweetCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getQuotedStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Status getQuotedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Place getPlace() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLang() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getInReplyToUserId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getInReplyToStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getInReplyToScreenName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public GeoLocation getGeoLocation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getFavoriteCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getCurrentUserRetweetId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Date getCreatedAt() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long[] getContributors() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		//Netral sentiment
		Status Neutral = new Status() {
			
			@Override
			public UserMentionEntity[] getUserMentionEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public URLEntity[] getURLEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public SymbolEntity[] getSymbolEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public MediaEntity[] getMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public HashtagEntity[] getHashtagEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public ExtendedMediaEntity[] getExtendedMediaEntities() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public RateLimitStatus getRateLimitStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getAccessLevel() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public int compareTo(Status o) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public boolean isTruncated() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweetedByMe() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweeted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isRetweet() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isPossiblySensitive() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFavorited() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public String[] getWithheldInCountries() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public User getUser() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getText() {
				// TODO Auto-generated method stub
				return "：-｜";
			}
			
			@Override
			public String getSource() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Scopes getScopes() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Status getRetweetedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getRetweetCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getQuotedStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Status getQuotedStatus() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public Place getPlace() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getLang() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getInReplyToUserId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getInReplyToStatusId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public String getInReplyToScreenName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long getId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public GeoLocation getGeoLocation() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getFavoriteCount() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public long getCurrentUserRetweetId() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public Date getCreatedAt() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public long[] getContributors() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		listTweet.add(sadSentiment);
		listTweet.add(happySentiment);
		listTweet.add(Neutral);
	}
	/**
	 * Test whether the words of happy are extracted correctly
	 * @author Gaoshuo Cui
	 */
	@Test
	public void testHappy() {
		long happyCount = new SentimentCount().getHappyCount(listTweet);
		assertEquals(1, happyCount);
	}
	/**
	 * Test whether the words of sad are extracted correctly
	 * @author Gaoshuo Cui
	 */
	@Test
	public void testSad() {
		long sadCount = new SentimentCount().getSadCount(listTweet);
		assertEquals(1, sadCount);
	}
	/**
	 * An exception class that will be thrown when TwitterAPI(mock) calls are failed.
	 * @author Gaoshuo Cui
	 */
	@Test
	public void getTwitterException() {
		TweetSentimentDetermine Ts= new TweetSentimentDetermine();
		ArrayNode str=Ts.getTweetSentiment("",0);
		assertTrue(str.size()==0);
	}
	@Test
	public void getTwitter() {
		TweetSentimentDetermine Ts= new TweetSentimentDetermine();
		ArrayNode str=Ts.getTweetSentiment(":-)",0);
		assertNotNull(str);
	}

	@Test
	public void getTwitts() {
		TweetsResult Ts= new TweetsResult();
		List<String> str=Ts.getTweets();
		assertNull(str);
	}
}
