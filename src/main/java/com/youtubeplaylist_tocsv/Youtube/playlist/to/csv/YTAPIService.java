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

    public static List<VideoDataModel> GetPlaylistData (String playlistid) throws IOException, JSONException {
            URL url = new URL("https://www.googleapis.com/youtube/v3/playlistItems?part=snippet%2C+id&playlistId="
                    + playlistid +"&key=" +
                    APIAuthKey.YOUTUBEAPI_KEY);
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

                    VideoDataModel video = new VideoDataModel(
                            jsonSnippet.getString("title"),
                            jsonSnippet.getString("description"),
                            jsonSnippet.getString("description"),
                            jsonSnippet.getString("publishedAt"));
                    videoList.add(video);
                }
                in.close();
                return videoList;
            } else {
                response.append("Something went wrong :(");
                System.out.println(response);
                return videoList;
            }
    }
}
