package interfaces;

import com.fasterxml.jackson.databind.node.ArrayNode;
import models.TweetDistinctWordCountResult;


/**
 * Interface to fetch distinct words and their count
 * @author Mengxuan Qiu
 * @version 1.0
 */
@FunctionalInterface
public interface TweetDistictWord {
	/**
	 * @param searchKey keyword
	 * @param count tweet number
	 * @return TweetDistinctWordCountResult
	 */
	TweetDistinctWordCountResult getTweetDistinctWordCount(String searchKey, int count);
}
