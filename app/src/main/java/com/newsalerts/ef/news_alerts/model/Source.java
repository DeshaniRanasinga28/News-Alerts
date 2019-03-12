package com.newsalerts.ef.news_alerts.model;

import java.io.Serializable;

/**
 * Created by EF on 02-Feb-18.
 */

public class Source implements Serializable{
    private String id;
    private String name;

    public Source(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nmae) {
        this.name = nmae;
    }
}
