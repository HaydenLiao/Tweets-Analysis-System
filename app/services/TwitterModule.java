package services;

import com.google.inject.AbstractModule;

import implementations.TwitterAPiInstanceImpl;
import interfaces.TwitterApiInstance;

/**
 * This class is to implement dependency injection.
 * @author Tianlin Yang
 * @version 1.0
 */
public class TwitterModule extends AbstractModule {

	/* (non-Javadoc)
	 * @see com.google.inject.AbstractModule#configure()
	 */
	@Override
	protected void configure() {
		bind(TwitterApiInstance.class).to(TwitterAPiInstanceImpl.class);
	}

}
