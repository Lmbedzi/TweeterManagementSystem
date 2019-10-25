package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.TweetEntity;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Session Bean implementation class TweetEJB
 */
@Stateless
@LocalBean
public class TweetEJB {

	@PersistenceContext
	private EntityManager tw;
	
    public TweetEJB() {

    }
    
    public void addNew(TweetEntity tweetEntity)  {
    	
//    	System.out.println("----Sending tweet to twitter-----");
//    	
//    	ConfigurationBuilder cb = new ConfigurationBuilder();
//    	
//    	cb.setDebugEnabled(true)
//    		.setOAuthConsumerKey("CtlKdruKUgoZcde5tP9ehH5fT ")
//    		.setOAuthConsumerSecret("mueKkZimhqy2gWMfa1HDgcc5odyXTk0ZGYtKK3t0cstaKw0kA4 ")
//    		.setOAuthAccessToken("1180847542550061056-y8UEBgSTb9NHvgDJai3UAekwYVi5sL")
//    		.setOAuthAccessTokenSecret("tq5U2VqSCe4mLAniLDIKSx8KuLdya2tzWngzH0SwFlrHa ");
//    	
//    	TwitterFactory tf = new TwitterFactory(cb.build());
//    	
//    	twitter4j.Twitter t4w =  tf.getInstance();
//    	
//    	//Post on twitter timeline
//    	Status stat  = t4w.updateStatus("My First Tweet");
//    	
//    	System.out.println("Twitter updated");
    	
    	System.out.println("***Adding tweet to the database****");
    	
    	tw.persist(tweetEntity);
    	
    	List <TweetEntity> tweets = new ArrayList<>();
    	
    	tweets = tw.createQuery("SELECT tweetID,timeStamp,tweetBody FROM tweet_tbl").getResultList();
    	
    	System.out.println("Tweets "+ tweets );
	
    }

	public List<TweetEntity> getTweet() {

    	List <TweetEntity> tweets = new ArrayList<>();
    	System.out.println("Tweet "+ tweets );
    	return tw.createQuery("SELECT tweetID,timeStamp,tweetBody FROM tweet_tbl").getResultList();
    	
    }
	
}
