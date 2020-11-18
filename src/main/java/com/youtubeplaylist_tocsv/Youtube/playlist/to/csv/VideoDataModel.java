package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

public class VideoDataModel {

    private final String title;
    private final String description;
    private final String id;
    private final String date;

    public VideoDataModel(String title, String description, String id, String date) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public String getDescr() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

}
