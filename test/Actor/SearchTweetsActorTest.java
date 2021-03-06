package Actor;

import static org.junit.Assert.*;

import implementations.ReturnTwitterObject;
import implementations.UserProfilePrint;
import models.UserProfileResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * This is to test search tweet's actor
 * @author Tianlin Yang
 * @version 1.0
 */
public class SearchTweetsActorTest {
	
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
		searchActor = actorSystem.actorOf(SearchTweetsActor.props(searchActor));
		ReturnTwitterObject.isTest = true;
        ReturnTwitterObject.emotion = "SAD";
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
//		searchActor.tell("test", ActorRef.noSender());
//		assertNotNull(searchActor);
		searchActor.tell("testing", ActorRef.noSender());
		assertFalse(searchActor.toString().length()==0);
//		ReturnTwitterObject.emotion="";
		searchActor.tell("", ActorRef.noSender());

		assertFalse(searchActor.toString().length()==0);


	}



}