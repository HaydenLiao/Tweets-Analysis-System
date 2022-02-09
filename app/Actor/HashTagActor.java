package Actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.TwitterAPItools;

/**
 * This is actor for fetching tweet's by hashtag's
 * @author Haitun Liao
 * @version 1.0
 * @see akka.actor.AbstractActor
 */
public class HashTagActor extends AbstractActor{

	/**
	 * This method is used to get props for actor
	 * @return Props
	 */
	public static Props props() {
		return Props.create(HashTagActor.class);
	}
	
	/**
	 * This is the message class for HashTagActor
	 * @author HaitunLiao
	 */
	public static class HashTagKey{
		public final String hashTagKey;
		
		/**
		 * @param hashTagKey hashTagKey
		 */
		public HashTagKey(String hashTagKey) {
			this.hashTagKey = hashTagKey;
		}
	}
	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		return receiveBuilder()
				.match(HashTagKey.class, searchKey->{
					sender().tell(TwitterAPItools.getHashTagTweets(searchKey.hashTagKey, 10), self());
				}).build();
	}

}
