package Actor;

import akka.actor.Actor;
import akka.testkit.TestActorRef;
import implementations.ReturnTwitterObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.testkit.javadsl.TestKit;

import static org.junit.Assert.*;

/**
 * This is to test tweet's sentiment actor
 * @author Gaoshuo Cui
 * @version 1.0
 */
public class TweetEmotionActorTest {

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
		searchActor = actorSystem.actorOf(TweetEmotionActor.props());

		ReturnTwitterObject.isTest = true;
        ReturnTwitterObject.emotion = "NEUTRAL";
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
	@Test
	public void testkey(){
		TweetEmotionActor.TweetEmotionKey key = new TweetEmotionActor.TweetEmotionKey("");
		String str=key.searchKey;
		assertEquals("",str);


	}
	/**
	 * This method run the test
	 */
	@Test
	public void test2() {
		TestKit probe = new TestKit(actorSystem);
		ActorRef deviceActor = actorSystem.actorOf(TweetEmotionActor.props());
		deviceActor.tell(new TweetEmotionActor.TweetEmotionKey("test"), probe.getRef());
		assertFalse(searchActor.toString().length()==0);
	}


}