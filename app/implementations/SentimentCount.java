package implementations;

import interfaces.HappyCount;
import interfaces.SadCount;
import twitter4j.Status;

import java.util.Arrays;
import java.util.List;

/**
 * This class implements the functionality of
 * determining if these tweets are overall happy ’:-)’, sad ’:-(’ or neutral ’:-|’
 * @author Gaoshuo Cui
 * @version 1.0
 * @see interfaces.HappyCount
 * @see interfaces.SadCount
 */
public class SentimentCount implements HappyCount,SadCount{	
	/**
	 * Process the stream of tweets, finding happy words, emojis, and emoticons and counting them.<br>
	 * Create a target list, using to identify emotional targets.<br>
     * It returns the number of tweets having happy sentiment.<br>
	 * @author Gaoshuo Cui
	 * @param ListTweets string type of target string
	 * @return count The number of words that match the sentiment
	 * @see HappyCount#getHappyCount(List)
	 */
	@Override
	public long getHappyCount(List<Status> ListTweets) {
		//Create a happylist to determine which words or expressions are happy emotions
		List<String> happyList=Arrays.asList("happy","good","perfect","joyful","cheerful","pleasure",
				"☺",":-)","😊","😄","😃","😀","🙂");
		//Stream processing was used to count the quantity that met the requirements
		long count = ListTweets.stream()
				                 .map(i -> i.getText())
				                 .filter(i -> happyList.contains(i))
				                 .count();
		return count;
	}
	/**
	 * Process the stream of tweets, finding sad words, emojis, and emoticons and counting them. <br>
	 * Create a target list, using to identify emotional targets.<br>
     * It returns the number of tweets having happy sentiment.<br>
	 * @author Gaoshuo Cui
	 * @param ListTweets string type of target string
	 * @return count The number of words that match the sentiment
	 * @see SadCount#getSadCount(List)
	 */
	@Override
	public long getSadCount(List<Status> ListTweets) {
		//Create a sadlist to determine which words or expressions are sad emotions
		List<String> sadList=Arrays.asList("sad","sadness","sorrow","grieved","painful","distress",
		"☹",":-(","😢","😭","😿","🙁","😟");
		//Stream processing was used to count the quantity that met the requirements
		long count = ListTweets.stream()
				                 .map(i -> i.getText())
				                 .filter(i -> sadList.contains(i))
				                 .count();
		return count;
	}

}