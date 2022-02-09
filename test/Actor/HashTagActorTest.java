package Actor;

import static org.junit.Assert.*;

import implementations.HashTagTweetsImpl;
import implementations.ReturnTwitterObject;
import implementations.UserProfilePrint;
import models.TweetsResult;
import models.UserProfileResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * This is to test hashtag actor
 * @author Tianlin Yang
 * @version 1.0
 */
public class HashTagActorTest {
	/**
	 * actorSystem - A object of ActorSystem
	 */
	public static ActorSystem actorSystem;
	/**
	 * searchActor - A object of ActorRef
	 */
	public static ActorRef searchActor;
	
	/**
	 * The method is to setup variable's for the test
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception
	{
		actorSystem = ActorSystem.create();
		searchActor = actorSystem.actorOf(HashTagActor.props());
		ReturnTwitterObject.isTest = true;
        ReturnTwitterObject.emotion = "HAPPY";
	}
	
	/**
	 * This method is to teardown the setup for test
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception{
		actorSystem = null;
		searchActor = null;
		ReturnTwitterObject.isTest = false;
        ReturnTwitterObject.emotion = "";
	}
	
	/**
	 * This method run the test
	 */
	@Test
	public void test() {
		searchActor.tell(new HashTagActor.HashTagKey("test"), ActorRef.noSender());
		assertFalse(searchActor.toString().length()==0);
	}
//	@Test
//	public void getExceptions() {
//		HashTagTweetsImpl Ts= new HashTagTweetsImpl();
//		TweetsResult str=Ts.getHashTweets("",0);
//		assertNotNull(str);
//		//assertTrue(str.getUserName()=="");
//	}
}