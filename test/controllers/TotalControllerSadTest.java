package controllers;

import akka.actor.ActorSystem;
import implementations.ReturnTwitterObject;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.WebSocket;
import twitter4j.TwitterException;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * This is to test total controller.
 * @author Tianlin Yang
 * @version 1.0
 */
public class TotalControllerSadTest {


    /**
     * controller- A object of TotalController.
     */
    public static TotalController controller;
    
    /**
     * system - A object of ActorSystem.
     */
    public static ActorSystem system;
    /**
     * The method is to setup variable's for the test
     */
    @BeforeClass
    public static void setUp() {
        system = ActorSystem.create();
        controller = new TotalController(system);
        ReturnTwitterObject.isTest = true;
        ReturnTwitterObject.emotion = "SAD";
    }
    /**
     * This method is to teardown the setup for test
     */
    @AfterClass
    public static void tearDown() {
        controller = null;
        system = null;
        ReturnTwitterObject.isTest = false;
        ReturnTwitterObject.emotion = "";
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void HashTagTest() throws InterruptedException, ExecutionException, TwitterException {
        CompletionStage<Result> result = controller.searchTweetsByHashTag("happy");
        Result r = result.toCompletableFuture().get();
        assertTrue(result.toString().length()>0);
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void UserProfileTest() throws InterruptedException, ExecutionException, TwitterException {
        CompletionStage<Result> result = controller.getUserProfile("PranavB83923688");
        Result r = result.toCompletableFuture().get();
        assertTrue(result.toString().length()>0);
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void TweetDistictWordsTest() throws InterruptedException, ExecutionException, TwitterException {
        CompletionStage<Result> result = controller.searchTweetDistinctWordCount("happy");
        Result r = result.toCompletableFuture().get();
        assertTrue(result.toString().length()>0);
    }


    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void EmotionalTest() throws InterruptedException, ExecutionException, TwitterException {
        CompletionStage<Result> result = controller.getTweetsEmotion("happy");
        Result r = result.toCompletableFuture().get();
        assertTrue(result.toString().length()>0);
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void SearchTest() throws InterruptedException, ExecutionException, TwitterException {
        WebSocket result = controller.socket();
        assertTrue(result.toString().length()>0);
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void indexTest() throws InterruptedException, ExecutionException, TwitterException {
        Result result = controller.index();
        assertTrue(result.toString().length()>0);
    }

    /**
     * This method run the test
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TwitterException
     */
    @Test
    public void originCheckTest() throws InterruptedException, ExecutionException, TwitterException {
        Http.RequestHeader request = null;
        boolean result = controller.originCheck(request);
        assertFalse(result);
    }
}
