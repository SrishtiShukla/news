package com.paypal.newsreader.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

public class FeedDetails {

    @NotNull(message = "Crawled Feed cannot be null")
    @NotEmpty(message = "Crawled Feed cannot not be empty")
    String crawledFeed;
    @NotNull(message = "Entities cannot not be null")
    @NotEmpty(message = "Crawled Feed cannot not be empty")
    List<String> entities;
    String twitter_handle;
    String link;

    public FeedDetails(String crawledFeed, List<String> entities, String twitter_handle, String link) {
        this.crawledFeed = crawledFeed;
        this.entities = entities;
        this.twitter_handle = twitter_handle;
        this.link = link;
    }

    public String getCrawledFeed() {
        return crawledFeed;
    }

    public void setCrawledFeed(String crawledFeed) {
        this.crawledFeed = crawledFeed;
    }

    public List<String> getEntities() {
        return entities;
    }

    public void setEntities(List<String> entities) {
        this.entities = entities;
    }

    public String getTwitter_handle() {
        return twitter_handle;
    }

    public void setTwitter_handle(String twitter_handle) {
        this.twitter_handle = twitter_handle;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
