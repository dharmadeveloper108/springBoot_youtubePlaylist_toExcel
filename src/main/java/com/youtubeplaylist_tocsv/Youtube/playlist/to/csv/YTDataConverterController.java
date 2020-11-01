package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import org.json.JSONException;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RequestMapping("api/yotubeData")
@RestController
public class YTDataConverterController {

    @GetMapping(path = "/getVideos")
    public List<VideoDataModel> getVideoData(@NonNull @RequestBody  String playlistId) throws GeneralSecurityException, IOException, JSONException {
        return YTAPIService.GetPlaylistData(playlistId);
    }
}
