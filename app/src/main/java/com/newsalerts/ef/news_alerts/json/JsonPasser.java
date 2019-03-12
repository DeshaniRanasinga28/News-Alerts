package com.newsalerts.ef.news_alerts.json;

import com.newsalerts.ef.news_alerts.model.Articles;
import com.newsalerts.ef.news_alerts.model.Source;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by EF on 12-Feb-18.
 */

public class JsonPasser {
    private static JSONObject object;

    public static ArrayList<Articles> getArticles(String response){
        String id;
        String name;
        String author;
        String title;
        String description;
        String url;
        String urlToImage;
        String publishedAt;

        ArrayList<Articles> articles1 = new ArrayList<>();
        try{

            JSONObject jsonObject = new JSONObject(response);
            //JsonArray Node
            JSONArray articlesArray = jsonObject.getJSONArray("articles");

            for(int i=0; i<articlesArray.length(); i++){
                JSONObject jObject = articlesArray.getJSONObject(i);

                ArrayList<Source>sourceArray = new ArrayList<Source>();
                JSONObject source = jObject.getJSONObject("source");
                for(int j=0; j<source.length(); j++){
                    if(source.getString("id").equals("null")){
                        id = "";
                    }else{
                        id = source.getString("id");
                    }

                    if(source.getString("name").equals("null")){
                        name = "";
                    }else{
                        name = source.getString("name");
                    }

                    sourceArray.add(new Source(id, name));
                }

//                 author = jObject.getString("author");
                if(jObject.getString("author").equals("null")){
                    author = "";
                }else{
                    author = jObject.getString("author");
                }
//                 title = jObject.getString("title");
                if(jObject.getString("title").equals("null")){
                    title = "";
                }else{
                    title = jObject.getString("title");
                }

                if(jObject.getString("description").equals("null")){
                    description = "";
                }else{
                    description = jObject.getString("description");
                }

                if(jObject.getString("url").equals("null")){
                    url = "";
                }else{
                    url = jObject.getString("url");
                }

                urlToImage = jObject.getString("urlToImage");

                if(jObject.getString("publishedAt").equals("null")){
                    publishedAt = "";
                }else{
                    publishedAt = jObject.getString("publishedAt");
                }

                articles1.add(new Articles(sourceArray, author, title, description, url, urlToImage, publishedAt));
            }
            return articles1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }


}
