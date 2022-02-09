package models;

import java.util.List;
/**
 * Twitter object for result handle
 * @author Tianlin Yang
 *
 */
public class TweetsResult {
	
	/**
	 * search key
	 */
	String searchKey;
	/**
	 * List of tweets
	 */
	List<String> tweets;
	
	/**
	 * Method to retrieve search key
	 * @return String
	 */
	public String getSearchKey() {
		return searchKey;
	}
	/**
	 * Method to put search key in Data Object
	 * @param searchKey
	 */
	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}
	/**
	 * Method  to return list of tweets
	 * @return List<String>
	 */
	public List<String> getTweets() {
		return tweets;
	}
	/**
	 * Method to put list of tweets
	 * @param tweets<String>
	 */
	public void setTweets(List<String> tweets) {
		this.tweets = tweets;
	}	
	
}
