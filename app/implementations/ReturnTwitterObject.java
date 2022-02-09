package implementations;

import com.google.inject.Inject;
import interfaces.TwitterApiInstance;
import models.MockHappy;
import models.MockNeutral;
import models.MockSad;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import twitter4j.Twitter;

import static play.inject.Bindings.bind;


/**
 * It provides the object of Twitter4j
 * @author Tianlin Yang
 * @version 1.0
 * @see interfaces.TwitterApiInstance
 *
 */
public class ReturnTwitterObject implements TwitterApiInstance {

	/**
	 * Twitter Object to be returned
	 */
	private static Twitter twitterInstance;
	/**
	 * boolean flag to check if it is for units tests or not
	 */
	public static boolean isTest = false;
	/**
	 * String for the type of testing
	 */
	public static String emotion = "";
	/**
	 * Application Object
	 */
	public static Application app;
	
	/**
	 * @param apiInstance
	 */
	@Inject
	public ReturnTwitterObject(TwitterApiInstance apiInstance) {
		this.twitterInstance = apiInstance.geTwitterInstance();
	}
	
	
	/* (non-Javadoc)
	 * @see interfaces.TwitterApiInstance#geTwitterInstance()
	 */
	@Override
	public Twitter geTwitterInstance() {
		if(!isTest) {
			return this.twitterInstance;
		}
		else {
			if(emotion.equals("HAPPY")) {
				app = new GuiceApplicationBuilder()
						.overrides(bind(TwitterApiInstance.class).to(MockHappy.class))
						.build();
				
				TwitterApiInstance apiInstance = app.injector().instanceOf(TwitterApiInstance.class);
				this.twitterInstance = apiInstance.geTwitterInstance();
				return this.twitterInstance;
			}else if(emotion.equals("SAD")) {
				app = new GuiceApplicationBuilder()
						.overrides(bind(TwitterApiInstance.class).to(MockSad.class))
						.build();
				
				TwitterApiInstance apiInstance = app.injector().instanceOf(TwitterApiInstance.class);
				this.twitterInstance = apiInstance.geTwitterInstance();
				return this.twitterInstance;
			}
			else if(emotion.equalsIgnoreCase("NEUTRAL")) {
				app = new GuiceApplicationBuilder()
						.overrides(bind(TwitterApiInstance.class).to(MockNeutral.class))
						.build();
				
				TwitterApiInstance apiInstance = app.injector().instanceOf(TwitterApiInstance.class);
				this.twitterInstance = apiInstance.geTwitterInstance();
				return this.twitterInstance; } }return null;
	}
	

}
