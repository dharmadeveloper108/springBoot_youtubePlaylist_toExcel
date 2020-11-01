package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

public class VideoDataModel {

    private final String videoTitle;
    private final String videoDescr;
    private final String videoId;
    private final String videoDate;

    public VideoDataModel(String videoLink, String videoTitle, String videoCreator, String videoDate) {
        this.videoDescr = videoLink;
        this.videoTitle = videoTitle;
        this.videoId = videoCreator;
        this.videoDate = videoDate;
    }

    public String getVideoDescr() {
        return videoDescr;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoId() {
        return videoId;
    }

    public String getVideoDate() {
        return videoDate;
    }

}
