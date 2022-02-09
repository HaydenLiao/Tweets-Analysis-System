package Actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.TwitterAPItools;

/**
 *  This is actor for counting the words in the tweet's
 * @author Mengxuan Qiu
 * @version 1.0
 * @see akka.actor.AbstractActor
 *
 */
public class TweetWordCountActor extends AbstractActor {

	/**
	 * This method returns the props
	 * @return
	 */
	public static Props props() {
		return Props.create(TweetWordCountActor.class);
	}
	
	/**
	 * This is the message class for counting words of tweets
	 * @author Mengxuan Qiu
	 *
	 */
	public static class TweetWordCountKey{
		public final String searchKey;
		
		public TweetWordCountKey(String searchKey) {
			this.searchKey = searchKey;
		}
	}
	
	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(TweetWordCountKey.class, searchKey->{
					sender().tell(TwitterAPItools.getTweetDistinctWordCount(searchKey.searchKey, 250), self());
				}).build();
	}

}
