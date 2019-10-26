package controller;

import javax.ejb.EJB;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import service.TweetEJB;
import model.TweetEntity;

@ApplicationPath("/resources")
@Path("/TweeterControllerRestService")
public class TweeterControllerRestService extends Application{
	
	@EJB
	TweetEJB tweetservice;
	
	@GET
	@Path("/message")
	@Produces("application/json")
	public String getMessage(){
		return "Hellow";
	}
	
	@GET
	@Path("/tweets")
	@Produces(MediaType.APPLICATION_JSON)
	public Iterable<TweetEntity> getAllTweets() {
		System.out.println("Post man");

		return tweetservice.getTweet();
	}

}
