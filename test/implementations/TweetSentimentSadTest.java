package implementations;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementations.TweetSentimentDetermine;
import org.junit.Test;

import services.TwitterAPItools;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import twitter4j.TwitterException;

import java.util.concurrent.ExecutionException;

/**
 * This class for test to sad tweets and catch exceptions
 * @version 1.1
 * @author Gaoshuo Cui
 *
 */
public class TweetSentimentSadTest {
	/** 
	 * setUp() method,set up the test environment to mock
	 * @author Gaoshuo Cui
	 */
	@BeforeClass
	public static void setUp() {
		TwitterAPItools.isTesting = true;
		TwitterAPItools.typeOfFake = "SAD";
	}
	/** 
	 * tearDown() method,recover the status of test environment
	 * @author Gaoshuo Cui
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterAPItools.isTesting = false;
		TwitterAPItools.typeOfFake = "";
	}
	/** 
	 * Test to check if sentiment in tweet is return sad emoij.
	 * @author Gaoshuo Cui
	 *
	 */
    @Test
    public void getTweetSentiment() {
		ArrayNode str = new TweetSentimentDetermine().getTweetSentiment("", 250);
		assertNotNull(str);
    }

}