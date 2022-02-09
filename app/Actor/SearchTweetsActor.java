package Actor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import play.libs.Json;
import services.TwitterAPItools;

/**
 * This is actor for searching tweet's
 * @author Mengxuan Qiu
 * @version 1.0
 * @see akka.actor.AbstractActor
 */
public class SearchTweetsActor extends AbstractActor{
	
	/**
	 * This method is used to get props for actor
	 * @param out
	 * @return
	 */
	public static Props props(ActorRef out) {
		System.out.println("Start SearchTweets Actor");
		return Props.create(SearchTweetsActor.class, out);
	}
	/**
	 * out - A variable of ActorRef
	 */
	private final ActorRef out;
	private ArrayNode searchResult;
	static ArrayNode HistorySearchResult = null;
	private int runtime = 0;
	/**
	 * @param out
	 */
	public SearchTweetsActor(ActorRef out) {
		this.out = out;
	}
	/* (non-Javadoc)
	 * @see akka.actor.AbstractActor#createReceive()
	 */
	@Override
	public Receive createReceive() {
		System.out.println("in actor");
		return receiveBuilder()
				.match(String.class, message->{
					System.out.println("received message: "+message);
					Runnable searchOperation = new Runnable() {
						
						@Override
						public void run() {
							//Method 1, not remove duplicate stuff, keep every pages as 10 tweets.
							try {
								int count=10;
								if (message=="")//If no new tweets, not update any page.
								{
									count = 0;
								} else//If new tweets coming, move the older twitter down, put newest on the top.
									{
									searchResult = TwitterAPItools.getTweets(message, count, 250);
//Method 2, remove duplicate stuff, not shown them at all!!!, tweets may vary from 0-10(upon updated things)
//										System.out.println("---------------Search result----------------\n"+searchResult+"\n------------------------------------------");
//										System.out.println("---------------Last result----------------\n"+ HistorySearchResult +"\n------------------------------------------");
//										duplicateFilter(searchResult);
//										if (runtime == 0) {
//											System.out.println("First time Run!");
//											HistorySearchResult = searchResult;
//										}
//										if (searchResult.size()>0 && runtime !=0){
//											HistorySearchResult = HistorySearchResult.addAll(searchResult);
//										}
//										System.out.println("---------------After Last result----------------\n"+ HistorySearchResult +"\n------------------------------------------");
//										System.out.println("---------------After Search result----------------\n"+searchResult+"\n------------------------------------------");

									ObjectNode node = Json.newObject();
									node.put("searchKey", message);
									searchResult.add(node);
									System.out.println("Get results numbers: " + (searchResult.size()-1));
									out.tell(searchResult.toString(), self());runtime ++;
								}

							}catch(Exception e) {  }
						}
					};
					ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
					service.scheduleAtFixedRate(searchOperation, 0, 10, TimeUnit.SECONDS);
				})
				.build();
	}
//	private void duplicateFilter(ArrayNode searchResult1) {
//		if (HistorySearchResult !=null){
//			int count = 0;
//			for (int i = 0; i < searchResult1.size(); i++){
//				for (int j = 0; j < HistorySearchResult.size(); j++){
//					if (HistorySearchResult.get(j).equals(searchResult1.get(i))){
//						count++;
//						System.out.println("Duplicated detected!not show multiple times!"+count);
//						ObjectNode node = Json.newObject();
//						node.put("", "");
//						searchResult1.remove(i);
//					}
//				} }
//			System.out.println("****** After remove duplicated, final result size = "+searchResult1.size());
//		}
//	}

}
