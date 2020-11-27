package com.youtubeplaylist_tocsv.Youtube.playlist.to.csv;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class YTAPIService {

    private static String KEY = System.getenv("API_KEY");

    public static List<VideoDataModel> GetPlaylistData (String playlistid) throws IOException, JSONException {
            URL url = new URL("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2C+id&maxResults=500&playlistId="
                    + playlistid +"&key=" +
                    KEY);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            StringBuffer response = new StringBuffer();
            List<VideoDataModel> videoList = new ArrayList<>();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                JSONObject jsonObject = new JSONObject(response.substring(0));
                JSONArray arrResponse = (JSONArray) jsonObject.get("items");

                for(int i=0; i<arrResponse.length(); i++){

                    String snippet = arrResponse.getJSONObject(i).getString("snippet");
                    JSONObject jsonSnippet = new JSONObject(snippet);

                    JSONObject jsonThumbnailUrl = null;
                    String thumbnails = jsonSnippet.getString("thumbnails");
                    JSONObject jsonThumbnails = new JSONObject(thumbnails);
                    if(jsonThumbnails.has("high")) {
                        String thumbnailUrl = jsonThumbnails.getString("high");
                        jsonThumbnailUrl = new JSONObject(thumbnailUrl);
                    }
//
                    String resourceId = jsonSnippet.getString("resourceId");
                    JSONObject jsonvideoId = new JSONObject(resourceId);

                    VideoDataModel video = new VideoDataModel(
                            jsonSnippet.getString("title"),
                            jsonSnippet.getString("description"),
                            jsonvideoId.getString("videoId"),
                            jsonSnippet.getString("publishedAt"),
                            (jsonThumbnails.has("high")) ? jsonThumbnailUrl.getString("url") : "");
                    videoList.add(video);
                }
                in.close();
            } else {
                response.append("Something went wrong :(");
                System.out.println(response);
            }
        return videoList;
    }

    public static SingleVideoModel GetVideoData (String videoId) throws IOException, JSONException {
        URL url = new URL("https://www.googleapis.com/youtube/v3/videos?part=id%2C+snippet&id="
                + videoId +"&key=" +
                KEY);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int responseCode = con.getResponseCode();
        StringBuffer response = new StringBuffer();
        List<String> videoTags = new ArrayList<>();
        SingleVideoModel video = null;

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            JSONObject jsonObject = new JSONObject(response.substring(0));
            JSONArray arrResponse = (JSONArray) jsonObject.get("items");

            for(int i=0; i<arrResponse.length(); i++){

                String snippet = arrResponse.getJSONObject(i).getString("snippet");
                JSONObject jsonSnippet = new JSONObject(snippet);

                String tags = jsonSnippet.getString("tags");
                JSONArray jsonTags = new JSONArray(tags);

                for (int j = 0; j < jsonTags.length(); j++) {
                    videoTags.add(jsonTags.getString(j));
                }

                video = new SingleVideoModel(videoTags,
                        jsonSnippet.getString("channelTitle"),
                        jsonSnippet.getString("defaultAudioLanguage"));
            }
            in.close();

        } else {
            response.append("Something went wrong :(");
            System.out.println(response);
        }
        return video;
    }
}
