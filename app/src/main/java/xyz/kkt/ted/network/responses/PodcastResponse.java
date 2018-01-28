package xyz.kkt.ted.network.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.PodcastVO;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class PodcastResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_podcasts")
    private List<PodcastVO> podcastList;

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

    public List<PodcastVO> getPodcastList() {
        return podcastList;
    }

    public void setPodcastList(List<PodcastVO> podcastList) {
        this.podcastList = podcastList;
    }
}
