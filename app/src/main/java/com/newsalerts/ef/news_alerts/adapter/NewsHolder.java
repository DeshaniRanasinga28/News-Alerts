package com.newsalerts.ef.news_alerts.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.newsalerts.ef.news_alerts.R;
import com.newsalerts.ef.news_alerts.WebViewActivity;

/**
 * Created by EF on 12-Feb-18.
 */

public class NewsHolder extends RecyclerView.ViewHolder {
    TextView sourceTextView;
    TextView authorTextView;
    TextView titleTextView;
    TextView descriptionTextView;
    TextView urlTextView;
    ImageView urlToImageImageView;
    TextView publishedAtTextView;
    private Context context;

    public NewsHolder(View itemView) {
        super(itemView);

        sourceTextView = (TextView)itemView.findViewById(R.id.source_txt);
        authorTextView = (TextView)itemView.findViewById(R.id.author_txt);
        titleTextView = (TextView)itemView.findViewById(R.id.title_txt);
        descriptionTextView = (TextView)itemView.findViewById(R.id.description_txt);
        urlTextView = (TextView)itemView.findViewById(R.id.url_txt);

        urlToImageImageView = (ImageView)itemView.findViewById(R.id.image_iv);
        publishedAtTextView = (TextView)itemView.findViewById(R.id.date_txt);

    }
}
