package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import java.util.List;

public class SingleVideoModel {

    private final List<String> tags;
    private final String channel;
    private final String language;

    public SingleVideoModel(List<String> tags, String channel, String language) {
        this.tags = tags;
        this.channel = channel;
        this.language = language;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getChannel() {
        return channel;
    }

    public String getLanguage() {
        return language;
    }
}
