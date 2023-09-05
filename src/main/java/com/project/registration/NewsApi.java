/*package com.project.registration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewsApi {
    public static String[] getNewsTitles() {
        try {
            URL url = new URL("https://newsapi.org/v2/top-headlines?country=in&apiKey=d59a50f863844fc59d62516cdc111fac");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            

            JSONObject json = new JSONObject(content.toString());
            JSONArray articles = json.getJSONArray("articles");
            String[] titles = new String[10];
            for (int i = 0; i < 10; i++) {
                JSONObject article = articles.getJSONObject(i);
                titles[i] = article.getString("title");
            }
          
            return titles;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}*/
package com.project.registration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewsApi {
	public static String[][] getNews() {
		try {
			String[][] news = new String[5][5]; // 5 categories, 5 articles each
	        String[] categories = {"general", "sports", "technology", "science", "entertainment"};
	        String apiKey = "d59a50f863844fc59d62516cdc111fac";
	            
	        for (int i = 0; i < categories.length; i++) {
	        	URL url = new URL("https://newsapi.org/v2/top-headlines?country=in&category="+categories[i]+"&apiKey=" + apiKey);
	            HttpURLConnection con = (HttpURLConnection) url.openConnection();
	            con.setRequestMethod("GET");

	            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	            String inputLine;
	            StringBuffer content = new StringBuffer();
	            while ((inputLine = in.readLine()) != null) {
	            	content.append(inputLine);
	            }

	           JSONObject json = new JSONObject(content.toString());
	           JSONArray articles = json.getJSONArray("articles");
	           for (int j = 0; j < 5; j++) {
	        	   JSONObject article = articles.getJSONObject(j);
	               news[i][j] = article.getString("title") + " -/ " + article.optString("description") + " -/ " + article.getString("url") + " -/ " + article.getString("publishedAt");
	           }
	       }
	        
	       return news;
	       
	   } catch (Exception e) {
		   e.printStackTrace();
	       return null;
	   }
	}
}






