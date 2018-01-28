package xyz.kkt.ted.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.kkt.ted.data.vos.PlaylistVO;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class PlaylistResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_playlists")
    private List<PlaylistVO> playlists;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public List<PlaylistVO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistVO> playlists) {
        this.playlists = playlists;
    }
}
