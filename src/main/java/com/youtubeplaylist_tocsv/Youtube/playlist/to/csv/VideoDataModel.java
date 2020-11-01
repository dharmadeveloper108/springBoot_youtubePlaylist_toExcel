package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

public class VideoDataModel {

    private final String videoTitle;
    private final String videoDescr;
    private final String videoId;
    private final String videoDate;

    public VideoDataModel(String videoTitle, String videoDescr, String videoLink, String videoDate) {
        this.videoTitle = videoTitle;
        this.videoDescr = videoDescr;
        this.videoId = videoLink;
        this.videoDate = videoDate;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoDescr() {
        return videoDescr;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getVideoDate() {
        return videoDate;
    }

}
