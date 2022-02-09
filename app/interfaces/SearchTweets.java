package interfaces;

import com.fasterxml.jackson.databind.node.ArrayNode;


/**
 * Interface to get tweet by search keyword
 * @author Mengxuan Qiu
 * @version 1.0
 */
@FunctionalInterface
public interface SearchTweets{
	/**
	 * @param searchKey
	 * @param count
	 * @return ArrayNode
	 */
	ArrayNode getTweetsAsync(String searchKey,int count);
}
