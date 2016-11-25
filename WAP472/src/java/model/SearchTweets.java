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
import java.util.List;
import java.util.logging.Level;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.7
 */
public class SearchTweets {
    /**
     * Usage: java twitter4j.examples.search.SearchTweets [query]
     *
     * @param args search query
     */
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
            //JSONObject loc;
         //  String loc=value.toString().substring(value.toString().indexOf("=")+1,value.toString().indexOf(","));
            
            //loc=gson.fromJson(value,Place).toJson();
                        System.out.println(value.toString());

            int woeid=1;
            woeid=value.getWoeid();
           // woeid=Integer.valueOf(loc);
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

             //  System.out.println(sometrend);
             //                 System.out.println(etc);

            }
            forreturn.append("]}");
            System.out.println(forreturn);
            
          //  etc=gson.toJson(forreturn);
            

/*
            Query query = new Query("tarkariwali");
          //  GeoQuery query = new GeoQuery(new GeoLocation(Double.parseDouble(args[0]), Double.parseDouble(args[1])));
            QueryResult result;
            int count=0;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                   count++;
                   if(count>=10)break;
                }
                 count++;
                    if(count>=10)break;
            } while ((query = result.nextQuery()) != null);
           // System.exit(0);
            
        }*/ 
        }catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
                    
return forreturn;
    }
    
}
