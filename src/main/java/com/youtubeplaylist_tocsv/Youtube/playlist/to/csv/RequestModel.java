package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestModel {

    private final String playlistId;

    public RequestModel( @JsonProperty("playlistId") String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistId() {
        return playlistId;
    }
}
