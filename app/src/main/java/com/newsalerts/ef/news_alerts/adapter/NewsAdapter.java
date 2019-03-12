package com.newsalerts.ef.news_alerts.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newsalerts.ef.news_alerts.R;
import com.newsalerts.ef.news_alerts.WebViewActivity;
import com.newsalerts.ef.news_alerts.model.Articles;
import com.newsalerts.ef.news_alerts.model.Source;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by EF on 12-Feb-18.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    private ArrayList<Articles> articlesList;
    private ArrayList<Source> sourceList;
    NewsHolder newsHolder;
    Context context;

    public NewsAdapter(ArrayList<Articles> articlesList, Context context) {
        this.articlesList = articlesList;
        this.context = context;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_rowitem, parent, false);
        newsHolder = new NewsHolder(view);
        return newsHolder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        final Articles articles = articlesList.get(position);
        Source source = articles.getSources().get(0);

        holder.sourceTextView.setText(source.getName());
        holder.titleTextView.setText(articles.getTitle());
        holder.descriptionTextView.setText(articles.getDescription());
        holder.urlTextView.setText(Html.fromHtml("<u>" + articles.getUrl() + "</u>"));
        holder.publishedAtTextView.setText(articles.getPublishedAt());

        String url = articles.getUrlToImage();
        Picasso.with(context)
                .load(url)
                .resize(250, 250)
                .centerCrop()
                .into(holder.urlToImageImageView);

//        holder.publishedAtTextView.setText(articles.getPublishedAt());

        holder.urlTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Bundle b = new Bundle();
                Intent intent = new Intent(context, WebViewActivity.class);
                b.putString("urlTxt", articles.getUrl().toString());
                intent.putExtras(b);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
