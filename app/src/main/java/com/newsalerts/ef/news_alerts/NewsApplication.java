package com.newsalerts.ef.news_alerts;

import android.app.Application;

import com.newsalerts.ef.news_alerts.util.NewsVolley;

/**
 * Created by EF on 08-Feb-18.
 */

public class NewsApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        inti();
    }

    private void inti() {
        NewsVolley.init(this);
    }
}
