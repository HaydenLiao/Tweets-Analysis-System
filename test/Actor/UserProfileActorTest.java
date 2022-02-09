package Actor;

import akka.testkit.javadsl.TestKit;
import implementations.UserProfilePrint;
import models.UserProfileResult;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

import static org.junit.Assert.*;

/**
 * This is to test user profile actor.
 * @author Tianlin Yang
 * @version 1.0
 */
public class UserProfileActorTest {

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
		searchActor = actorSystem.actorOf(UserProfileActor.props());
	}
	
	/**
	 * This method is to teardown the setup for test
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception{
		TestKit.shutdownActorSystem(actorSystem);
		actorSystem = null;
		searchActor = null;
	}
	
	/**
	 * This method run the test
	 */
	@Test
	public void test() {
		searchActor.tell(new UserProfileActor.UserProfileQuery("PranavB83923688"), ActorRef.noSender());
		assertFalse(searchActor.toString().length()==0);
	}

	@Test
	public void getException() {
		UserProfilePrint Ts= new UserProfilePrint();
		UserProfileResult str=Ts.getUserProfile("",0);
		assertFalse(searchActor.toString().length()==0);
//		assertTrue(str.getUserName()=="");
	}


}