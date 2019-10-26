package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TweetEntity;
import twitter4j.DirectMessage;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Session Bean implementation class TweetEJB
 */
@Stateless
@LocalBean
public class TweetEJB {

	@PersistenceContext
	private EntityManager tw;

    public void sendDirectMessage(String message) throws TwitterException{
    	System.out.println("----Sending direct tweet to the lecture-----");
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    		.setOAuthConsumerKey("CtlKdruKUgoZcde5tP9ehH5fT")
    		.setOAuthConsumerSecret("mueKkZimhqy2gWMfa1HDgcc5odyXTk0ZGYtKK3t0cstaKw0kA4")
    		.setOAuthAccessToken("1180847542550061056-jiDtCKUzSiRojGBjCnCITo6APxP84P")
    		.setOAuthAccessTokenSecret("R88eRAswEQsFzXIeOdlNtEAyDbIHqpg2GJYmbw73yVG3f");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	twitter4j.Twitter t4w =  tf.getInstance();
    	
    	DirectMessage msg = t4w.sendDirectMessage("@herongwako",message);
    	
    	System.out.println("Message sent "+ msg);
    }
    
    public void addNew(TweetEntity tweetEntity) throws TwitterException  {
    	
    	System.out.println("----Saving tweet to database & publishing it to timeline-----");
    	tw.persist(tweetEntity);
    	
    	ConfigurationBuilder cb = new ConfigurationBuilder();
    	cb.setDebugEnabled(true)
    		.setOAuthConsumerKey("CtlKdruKUgoZcde5tP9ehH5fT")
    		.setOAuthConsumerSecret("mueKkZimhqy2gWMfa1HDgcc5odyXTk0ZGYtKK3t0cstaKw0kA4")
    		.setOAuthAccessToken("1180847542550061056-jiDtCKUzSiRojGBjCnCITo6APxP84P")
    		.setOAuthAccessTokenSecret("R88eRAswEQsFzXIeOdlNtEAyDbIHqpg2GJYmbw73yVG3f");
    	
    	TwitterFactory tf = new TwitterFactory(cb.build());
    	twitter4j.Twitter t4w =  tf.getInstance();
    	//Post on twitter timeline
    	Status stat  = t4w.updateStatus(tweetEntity.getTweetBody());
    	System.out.println("Twitter posted");
	
    }

	public List<TweetEntity> getTweet() {

    	List <TweetEntity> tweets = new ArrayList<>();
    	System.out.println("Tweet "+ tweets );
    	return tw.createQuery("SELECT tweetID,timeStamp,tweetBody FROM tweet_tbl").getResultList();
    	
    }
	
}
