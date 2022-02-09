package implementations;

import interfaces.TwitterApiInstance;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;


/**
 * The class provides implementation to create object for Twitter4j to connect to twitter
 * @author Tianlin Yang
 * @version 1.0
 * @see interfaces.TwitterApiInstance
 *
 */
public class TwitterAPiInstanceImpl implements TwitterApiInstance {

	/**
	 * Twitter Object
	 */
	private static Twitter realTwitter;
	/* (non-Javadoc)
	 * @see interfaces.TwitterApiInstance#geTwitterInstance()
	 */
	@Override
	public Twitter geTwitterInstance() {
		if(realTwitter == null) {
			ConfigurationBuilder conf = new ConfigurationBuilder();
			conf.setDebugEnabled(true)
					.setOAuthConsumerKey("LOhcQELZKEIP0P1Ptxw8JfGFn")
					.setOAuthConsumerSecret("ScICw2Gbdpo240AJSrzRG2oCboQKGUUwZQcBkmNSgk9TWuhGAb")
					.setOAuthAccessToken("1327078420677849088-23IMWoQ6gItHyAN2MojsMDFrcEmmVK")
					.setOAuthAccessTokenSecret("8sPQCn9BlpFWP0d7cwslrPkpmgUniIJvovt1boogEalS4");
			TwitterFactory factory = new TwitterFactory(conf.build());
			realTwitter =  factory.getInstance();
		}
		return realTwitter;
	}

}
