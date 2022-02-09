package interfaces;

import twitter4j.Status;

import java.util.List;


/**
 * Interface to count sad words
 * @author Gaoshuo Cui
 * @version 1.0
 */
@FunctionalInterface
public interface SadCount {
	/**
	 * @param ListTweets
	 * @return long get the number of sad sentiment words
	 */
	long getSadCount(List<Status> ListTweets);
}
