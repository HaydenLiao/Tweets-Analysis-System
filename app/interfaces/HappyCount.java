package interfaces;

import twitter4j.Status;

import java.util.List;

/**
 * Interface to count Happy words
 * @author Gaoshuo Cui
 * @version 1.0
 */
@FunctionalInterface
public interface HappyCount {
	/**
	 * @param ListTweets
	 * @return long get the number of happy sentiment words
	 */
	long getHappyCount(List<Status> ListTweets);
}
