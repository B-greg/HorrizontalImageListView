package com.smartsoftasia.module.HorrizontalImageListView.Model;

/**
 * Created by gregoire on 10/17/14.
 */
public class HorizontalListViewModel {
    private String url;
    private String uri;

    public HorizontalListViewModel() {
        this.uri = null;
        this.url = null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
