package xyz.kkt.ted.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class PlaylistVO {

    @SerializedName("playlist_id")
    private int playlistId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("totalTalks")
    private int totalTalks;

    @SerializedName("description")
    private String description;

    @SerializedName("talksInPlaylist")
    private List<TalksVO> talkList;

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public void setTotalTalks(int totalTalks) {
        this.totalTalks = totalTalks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TalksVO> getTalkList() {
        return talkList;
    }

    public void setTalkList(List<TalksVO> talkList) {
        this.talkList = talkList;
    }
}
