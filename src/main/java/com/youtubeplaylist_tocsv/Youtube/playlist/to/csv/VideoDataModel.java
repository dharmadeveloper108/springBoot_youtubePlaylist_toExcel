package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

public class VideoDataModel {

    private final String videoLink;
    private final String videoTitle;
    private final String videoCreator;
    private final String videoDate;
    private final double videoViews;
    private final double videoLikes;

    public VideoDataModel(String videoLink, String videoTitle, String videoCreator, String videoDate, double videoViews, double videoLikes) {
        this.videoLink = videoLink;
        this.videoTitle = videoTitle;
        this.videoCreator = videoCreator;
        this.videoDate = videoDate;
        this.videoViews = videoViews;
        this.videoLikes = videoLikes;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoCreator() {
        return videoCreator;
    }

    public String getVideoDate() {
        return videoDate;
    }

    public double getVideoViews() {
        return videoViews;
    }

    public double getVideoLikes() {
        return videoLikes;
    }
}
