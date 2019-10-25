package controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import model.Tweet;
import service.TweetEJB;
import twitter4j.TwitterException;

@ManagedBean(name="tweetcontroller")
@SessionScoped
public class TweetController {
	
	@EJB
	TweetEJB tweetservice;

	@ManagedProperty(value="#{tweet}")
	private Tweet tweet;
	

	public void addNewTweet() {
		System.out.println("Button clicked to send tweet");
		tweetservice.addNew(tweet.getEntity());
	}


	public Tweet getTweet() {
		return tweet;
	}


	public void setTweet(Tweet tweet) {
		this.tweet = tweet;
	}
	
	
}
