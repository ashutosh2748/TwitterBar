
package model;

import twitter4j.*;
import com.google.gson.Gson;
import java.util.List;
import java.util.logging.Level;


public class SearchTweets {
   
    public static void main(String[] args){
        returnTrend(41,-92);
    }
    public static Object returnTrend(double latitude,double longitude) {
        if (false) {
            System.out.println("java twitter4j.examples.search.SearchTweets [query]");
            System.exit(-1);
        }
        StringBuilder forreturn=new StringBuilder();
        forreturn.append("{\"trends\":[") ;
        
        Twitter twitter = new TwitterFactory().getInstance();
          Object etc=new Object();
        GeoLocation gl;
        System.out.println(latitude+"   "+longitude);
        gl = new GeoLocation(latitude,longitude);
        try {
            ResponseList<Location> responselist;
            responselist = twitter.getClosestTrends(gl);
            System.out.println(responselist.toString());
            Location value=responselist.get(0);
                       System.out.println(value.toString());

            int woeid=1;
            woeid=value.getWoeid();
        
                        System.out.println("SearchTweet TEsting Console");

            Trends placeTrends = twitter.getPlaceTrends(woeid);
            
            int count=0;
            Gson gson=new Gson();
            System.out.println(etc);
            for(Trend sometrend: placeTrends.getTrends()){
                etc=gson.toJson(sometrend);
                forreturn.append(etc);
                count++;
                if(count>5)break;
                forreturn.append(",");

       
            }
            forreturn.append("]}");
            System.out.println(forreturn);
            
          
        }catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
                    
return forreturn;
    }
    
}
