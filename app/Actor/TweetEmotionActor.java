package Actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.TwitterAPItools;

/**
 * This is actor for fetching tweet's sentiment
 * @author Gaoshuo Cui
 * @version 1.0
 * @see akka.actor.AbstractActor
 *
 */
public class TweetEmotionActor extends AbstractActor {

	/**
	 * Props method
	 * @return
	 */
	public static Props props() {
		return Props.create(TweetEmotionActor.class);
	}
	
	/**
	 * This is the message class for tweet's sentiment actor
	 * @author Gaoshuo Cui
	 * @version 1.0
	 *
	 */
	public static class TweetEmotionKey{
		public final String searchKey;
		
		public TweetEmotionKey(String searchKey) {

			this.searchKey = searchKey;
		}
	}
	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(TweetEmotionKey.class, searchKey->{
					sender().tell(TwitterAPItools.getTweetsEmotion(searchKey.searchKey,250), self());
				}).build();
	}


}
