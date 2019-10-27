package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="tweet")
@SessionScoped
public class Tweet {
	
	private String tweetBody;
	private String timeStamp = new SimpleDateFormat("yyyy-MM-'T'HH:mm:ss").format(new Date());
	
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
	
	public TweetEntity getEntity() {
		TweetEntity tweetentity = new TweetEntity();
		tweetentity.setTweetBody(tweetBody);
		tweetentity.setTimeStamp(timeStamp);
		return tweetentity;
	}
	
	
}
