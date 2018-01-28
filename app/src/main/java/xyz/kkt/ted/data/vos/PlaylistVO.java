package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/27/2018.
 */

@Entity(tableName = TEDConstants.TED_PLAY_LIST_TABLE_NAME)//table name py tr
@TypeConverters(TalksInPlaylistTypeConverter.class)
public class PlaylistVO {

    @PrimaryKey(autoGenerate = true)
    private long playlistTedId;

    @SerializedName("description")
    private String description;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("playlist_id")
    private int playlistId;

    @SerializedName("talksInPlaylist")
    private List<TalksInPlaylistVO> talksInPlaylistLists;

    @SerializedName("title")
    private String title;

    @SerializedName("totalTalks")
    private int totalTalks;

    public long getPlaylistTedId() {
        return playlistTedId;
    }

    public void setPlaylistTedId(long playlistTedId) {
        this.playlistTedId = playlistTedId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public List<TalksInPlaylistVO> getTalksInPlaylistLists() {
        return talksInPlaylistLists;
    }

    public void setTalksInPlaylistLists(List<TalksInPlaylistVO> talksInPlaylistLists) {
        this.talksInPlaylistLists = talksInPlaylistLists;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTotalTalks() {
        return totalTalks;
    }

    public void setTotalTalks(int totalTalks) {
        this.totalTalks = totalTalks;
    }
}
