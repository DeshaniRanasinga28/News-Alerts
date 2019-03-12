package com.newsalerts.ef.news_alerts.toolbox;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by EF on 02-Feb-18.
 */

public class BitmapLruCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public BitmapLruCache(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {

    }
}
