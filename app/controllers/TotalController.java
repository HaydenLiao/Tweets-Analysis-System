package controllers;

import Actor.*;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.inject.Inject;
import models.TweetDistinctWordCountResult;
import models.TweetsResult;
import models.UserProfileResult;
import play.libs.F;
import play.libs.streams.ActorFlow;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.WebSocket;
import scala.compat.java8.FutureConverters;
import services.TwitterAPItools;
import twitter4j.TwitterException;
import views.html.*;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static akka.pattern.Patterns.ask;


/**
 * Date Dec 04,2020
 * This is controller for twitter assignment 1
 * @author Tianlin Yang
 * @version 1.0
 * @see play.mvc.Controller
 *
 */
public class TotalController extends Controller{

    /**
     * Actor Reference of actors being used
     */
    private final ActorRef hashTagActor;
    private final ActorRef userProfileActor;
    private final ActorRef tweetWordCountActor;
    private final ActorRef tweetEmotionActor;

    /**
     * @param system of type ActorSystem
     */
    @Inject
    public TotalController(ActorSystem system) {
        hashTagActor = system.actorOf(HashTagActor.props());
        userProfileActor = system.actorOf(UserProfileActor.props());
        tweetWordCountActor = system.actorOf(TweetWordCountActor.props());
        tweetEmotionActor = system.actorOf(TweetEmotionActor.props());
    }


    /**
     * ActorSystem Object
     */
    @com.google.inject.Inject private ActorSystem actorSystem;
    /**
     *Materializer Object
     */
    @com.google.inject.Inject private Materializer materializer;


    //------------------------------------------------ Methods Part -------------------------------------------------




    /**
     * This method asynchronously fetches tweet's by hashtag's
     * @author Tianlin Yang
     * @param searchKey
     * @return Result
     * @throws TwitterException
     */
    public CompletionStage<Result> searchTweetsByHashTag(String searchKey) throws TwitterException{
        return FutureConverters.toJava(ask(hashTagActor,new HashTagActor.HashTagKey(searchKey),5000))
                .thenApply(response->ok(hashTagPage.render((TweetsResult)response)));
    }

    /**
     * This method asynchronously fetches the user profile and displays
     * their Username, location, picture and 10 latest tweet's.
     * @author Tianlin Yang
     * @param userName - A string
     * @return Result
     * @throws TwitterException
     */
    public CompletionStage<Result> getUserProfile(String userName) throws TwitterException{
        return FutureConverters.toJava(ask(userProfileActor,new UserProfileActor.UserProfileQuery(userName),10000))
                .thenApply(response->ok(userProfilePage.render((UserProfileResult)response)));
    }


    /**
     * This method asynchronously counts the distinct words
     * in 100 latest tweets and displaying it.
     * @author Tianlin Yang
     * @param tweetWord - A string of keyword(s)
     * @return Result
     * @throws TwitterException
     */
    public CompletionStage<Result> searchTweetDistinctWordCount(String tweetWord) throws TwitterException{
        return FutureConverters.toJava(ask(tweetWordCountActor,new TweetWordCountActor.TweetWordCountKey(tweetWord),5000))
                .thenApply(response->ok(tweetWordCountPage.render((TweetDistinctWordCountResult)response)));
    }
    /**
     * This method is used to make connection to websocket
     * It will provide the connection for pushing tweets.
     * @return WebSocket
     */
    public WebSocket socket() {
        System.out.println("in controller");
        return WebSocket.Text.acceptOrResult(request->{ if(originCheck(request)){ return CompletableFuture.completedFuture(F.Either.Right(ActorFlow.actorRef(SearchTweetsActor::props, actorSystem, materializer))); } else { return CompletableFuture.completedFuture(F.Either.Left(forbidden())); } });
    }

    /**
     * This method will check if the request is coming from reliable source or not.
     * @param request of type Http.RequestHeader
     * @return boolean
     */
    public boolean originCheck(Http.RequestHeader request) {
        if (request==null){
            return false; }else { final Optional<String> origin = request.header("Origin");if (!origin.isPresent()) { return false; } else if (origin.get().contains("localhost:9000") || origin.get().contains("localhost:19001")) { return true; } else { return false; } }
    }

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(search.render());
    }

    /**
     * The method is used to get the tweet sentiment
     * @param Key
     * @return CompletionStage<Result>
     */
    public CompletionStage<Result> getTweetsEmotion(String Key) {
        return FutureConverters.toJava(ask(tweetEmotionActor, new TweetEmotionActor.TweetEmotionKey(Key),5000))
                .thenApplyAsync(tweets->ok((ArrayNode)tweets));
    }
}
