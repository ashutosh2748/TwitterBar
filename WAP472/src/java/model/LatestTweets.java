

package model;

import twitter4j.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;


public class LatestTweets {
   
    public static void main(String[] args){
        returnTweets("tarkariwali");
    }
    public static Object returnTweets(String genre) {
        
        String forreturn="";
      
        
        Twitter twitter = new TwitterFactory().getInstance();
         
        try {
         
            Gson gson=new Gson();
                          

            
         
            


            Query query = new Query(genre);
            query.setCount(8);
        
            QueryResult result;
           
             List<Tweet> returntweet=new ArrayList();
            
            
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
             
                for (Status tweet : tweets) {
                   
                    Tweet twit=new Tweet();
                    twit.setUserid(tweet.getUser().getScreenName());
                    twit.setText(tweet.getText());
                    twit.setUrl("http://twitter.com/"+twit.getUserid());
                    twit.setFullname(tweet.getUser().getName());
                    twit.setImgurl(tweet.getUser().getBiggerProfileImageURL());
                    returntweet.add(twit);
                   
             
                  
                }
               
                    
            
            
            forreturn=gson.toJson(returntweet);
           System.out.print(forreturn);
            
        
        }catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
     

return forreturn;
    }
    
}
