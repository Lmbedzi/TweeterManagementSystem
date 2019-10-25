package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="tweet_tbl")
public class TweetEntity {
	
	@Id
	@GeneratedValue(generator="tweet_seq")
	@SequenceGenerator(initialValue= 0001, name="tweet_seq")
	private int tweetID;
	private String tweetBody;
	private String timeStamp = new SimpleDateFormat("yyyy-MM-'T'ddHH:mm:ss").format(new Date());
	
	public int getTweetID() {
		return tweetID;
	}
	public void setTweetID(int tweetID) {
		this.tweetID = tweetID;
	}
	public String getTweetBody() {
		return tweetBody;
	}
	public void setTweetBody(String tweetBody) {
		this.tweetBody = tweetBody;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	
}
