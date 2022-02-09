package interfaces;

import com.fasterxml.jackson.databind.node.ArrayNode;
import models.UserProfileResult;

/**
 * The interface for user profile implementation.
 * @author Tianlin Yang
 * @version 1.0
 */
@FunctionalInterface
public interface UserProfile {
	/**
	 * @author Tianlin Yang
	 * @param searchKey Keyword
	 * @param count Tweets number
	 * @return Get the user profile
	 */

	UserProfileResult getUserProfile(String searchKey, int count);
}
