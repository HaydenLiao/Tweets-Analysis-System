package interfaces;


import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Interface to get sentiment from tweets
 * @author Gaoshuo Cui
 * @version 1.0
 */
@FunctionalInterface
public interface TweetSentiment {
	
	/**
	 * @param searchKey
	 * @param count
	 * @return ArrayNode
	 */
	ArrayNode getTweetSentiment(String searchKey, int count);
}
