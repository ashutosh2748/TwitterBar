/*
 * Copyright 2007 Yusuke Yamamoto
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model;

import twitter4j.*;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class LatestTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */
    public static void main(String[] args){
        returnTweets("tarkariwali");
    }
    public static Object returnTweets(String genre) {
        
        String forreturn="";
       // forreturn.append("{\"trends\":[") ;
        
        Twitter twitter = new TwitterFactory().getInstance();
          //Object etc=new Object();
        
        
       // gl = new GeoLocation(latitude,longitude);
        try {
           // ResponseList tt;
           // tt = twitter.getClosestTrends(gl);
           // System.out.println(tt.toString());
          //  Object value=tt.get(0);
            //JSONObject loc;
         //  String loc=value.toString().substring(value.toString().indexOf("=")+1,value.toString().indexOf(","));
            
            //loc=gson.fromJson(value,Place).toJson();
               //         System.out.println(value.toString());

          //  int woeid=1;
         //   woeid=Integer.valueOf(loc);
         //               System.out.println("SearchTweet TEsting Console");

         //   Trends placeTrends = twitter.getPlaceTrends(woeid);
            
           // int count=0;
            Gson gson=new Gson();
                          

            
          //  etc=gson.toJson(forreturn);
            


            Query query = new Query(genre);
            query.setCount(8);
          //  GeoQuery query = new GeoQuery(new GeoLocation(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
            QueryResult result;
           
             List<Tweet> returntweet=new ArrayList();
            
            
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
               // String etc;
               
                
               // System.out.println(etc);
                for (Status tweet : tweets) {
                    //System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                    Tweet twit=new Tweet();
                    twit.setUserid(tweet.getUser().getScreenName());
                    twit.setText(tweet.getText());
                    twit.setUrl("http://twitter.com/"+twit.getUserid());
                    twit.setFullname(tweet.getUser().getName());
                    twit.setImgurl(tweet.getUser().getBiggerProfileImageURL());
                    returntweet.add(twit);
                   
               // forreturn.append(etc);
                  
                }
               
                    
            
            
            forreturn=gson.toJson(returntweet);
           System.out.print(forreturn);
            
        
        }catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
         //  System.out.println(forreturn);

return forreturn;
    }
    
}
