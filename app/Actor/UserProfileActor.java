package Actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.TwitterAPItools;

/**
 * This is actor for fetching tweet's by location
 * @author Tianlin Yang
 * @version 1.0
 * @see akka.actor.AbstractActor
 */
public class UserProfileActor extends AbstractActor{

	/**
	 * This method is used to get props for actor
	 * @return Props
	 */
	public static Props props() {
		return Props.create(UserProfileActor.class);
	}
	
	/**
	 * This is the message class for user profile actor
	 * @author Tianlin Yang
	 * @version 1.0
	 *
	 */
	public static class UserProfileQuery{
		public final String userName;
		
		public UserProfileQuery(String userName) {
			this.userName = userName;
		}
	}
	
	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		// TODO Auto-generated method stub
		return receiveBuilder()
				.match(UserProfileQuery.class, profileQuery->{
					sender().tell(TwitterAPItools.getUserProfile(profileQuery.userName, 10), self());
				}).build();
	}
	
	

}
