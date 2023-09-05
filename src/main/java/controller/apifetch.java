package controller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.*;

import javax.servlet.*;
public class apifetch 
{
    public static void main(String[] args) throws ServletException, IOException, InterruptedException, JSONException
    {
        var url = "https://newsapi.org/v2/top-headlines?country=in&apiKey=d59a50f863844fc59d62516cdc111fac";
        var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        var client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //assign your JSON String here
        JSONObject obj = new JSONObject(response.body());
        //String pageName = obj.getJSONObject("pageInfo").getString("pageName");
        
        JSONArray arr = obj.getJSONArray("articles"); // notice that `"posts": [...]`
        
        for (int i = 0; i < 10; i++)
        {
            String t = arr.getJSONObject(i).getString("title");
            System.out.println(t);
            
        }
    } 
}