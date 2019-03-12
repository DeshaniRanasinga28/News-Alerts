package com.newsalerts.ef.news_alerts.util;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.newsalerts.ef.news_alerts.toolbox.BitmapLruCache;

/**
 * Created by EF on 08-Feb-18.
 */

public class NewsVolley {

    private static final int MAX_IMAGE_CACHE_ENTIERS = 100;

    private static RequestQueue requestQueue;
    private static ImageLoader imageLoader;

    public NewsVolley() {

    }

    public static void init(Context context){
        requestQueue = Volley.newRequestQueue(context);
        imageLoader = new ImageLoader(requestQueue, new BitmapLruCache(MAX_IMAGE_CACHE_ENTIERS));
    }

    public static RequestQueue getRequestQueue() {
        if(requestQueue != null){
            return requestQueue;
        }else {
            throw  new IllegalStateException("RequestQueue not initialized");
        }
    }

    public static ImageLoader getImageLoader() {
        if(imageLoader != null){
            return imageLoader;
        }else{
            throw new IllegalStateException("ImageLoader not initialized");
        }
    }
}
