package implementations;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementations.TweetSentimentDetermine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import services.TwitterAPItools;
/** 
 * this class for test to happy  sentiment tweets.
 * @version 1.0
 * @author Gaoshuo Cui
 *
 */
public class TweetSentimentHappyTest{
	/** 
	 * set up the test environment to mock
	 * @version 1.0
	 * @author Gaoshuo Cui
	 *
	 */
	@BeforeClass
	public static void setUp() {
		TwitterAPItools.isTesting = true;
		TwitterAPItools.typeOfFake = "HAPPY";
	}
	/** 
	 * tearDown() method, recover the status of test environment
	 * @author Gaoshuo Cui
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterAPItools.isTesting = false;
		TwitterAPItools.typeOfFake = "";
	}
	/** 
	 * Test to check if sentiment in tweet is return happy emoji.
	 * @author Gaoshuo Cui
	 *
	 */
    @Test
    public void getTweetSentiment() {
    	ArrayNode str = new TweetSentimentDetermine().getTweetSentiment("", 250);
    	assertNotNull(str);

    }
}
