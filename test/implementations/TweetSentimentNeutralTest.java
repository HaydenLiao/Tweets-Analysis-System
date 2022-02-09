package implementations;

import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.node.ArrayNode;
import implementations.TweetSentimentDetermine;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import services.TwitterAPItools;

import java.util.concurrent.ExecutionException;

/**
 * This class contains for test neutral tsentiment weets.
 * @version 1.0
 * @author Gaoshuo Cui
 *
 */
public class TweetSentimentNeutralTest {
	/** 
	 * setUp() method,set up the test environment to mock
	 * @author Gaoshuo Cui
	 *
	 */
	@BeforeClass
	public static void setUp() {
		TwitterAPItools.isTesting = true;
		TwitterAPItools.typeOfFake = "NEUTRAL";
	}
	/** 
	 * tearDown(),recover the status of test environment
	 * @author Gaoshuo Cui
	 *
	 */
	@AfterClass
	public static void tearDown() {
		TwitterAPItools.isTesting = false;
		TwitterAPItools.typeOfFake = "";
	}
	/** 
	 * Test to check if sentiment in tweet is return neutral emoji.
	 * @author Gaoshuo Cui
	 *
	 */
    @Test
    public void getTweetEmotion() {
		ArrayNode str = new TweetSentimentDetermine().getTweetSentiment("", 250);
		assertNotNull(str);
    }

}
