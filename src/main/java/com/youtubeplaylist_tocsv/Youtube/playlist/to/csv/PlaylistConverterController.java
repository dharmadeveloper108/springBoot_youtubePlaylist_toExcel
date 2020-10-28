package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/yotubeData")
@RestController
public class PlaylistConverterController {

    @GetMapping(path = "/getVideos")
    public VideoDataModel getVideoData() {
        VideoDataModel videoDataModel = new VideoDataModel("",
                "",
                "",
                "",
                0,
                0);
        return videoDataModel;
    }
}
