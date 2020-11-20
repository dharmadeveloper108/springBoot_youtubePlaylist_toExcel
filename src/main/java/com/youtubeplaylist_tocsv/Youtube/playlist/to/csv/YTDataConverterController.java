package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import org.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

//@CrossOrigin(origins = "*")
@RequestMapping("api/youtubeData/getVideos")
@RestController
public class YTDataConverterController {

    @GetMapping(path = "/{id}")
    public List<VideoDataModel> getVideoData(@PathVariable("id") String playlistId) throws GeneralSecurityException, IOException, JSONException {
        return YTAPIService.GetPlaylistData(playlistId.substring(3));
    }

    @GetMapping(path = "/toExcel")
    public void writeDataToExcel(@NonNull @RequestBody String playlistId) throws IOException, JSONException {
        List<VideoDataModel> videoDataModelList = YTAPIService.GetPlaylistData(playlistId);
        ExcelWriter.generateExcel(videoDataModelList);
    }
}
