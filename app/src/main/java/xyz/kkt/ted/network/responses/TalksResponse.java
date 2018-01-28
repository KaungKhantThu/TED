package xyz.kkt.ted.network.responses;

import android.arch.lifecycle.LiveData;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by Lenovo on 1/25/2018.
 */

public class TalksResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("ted_talks")
    private List<TalksVO> talkList;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<TalksVO> getTalkList() {
        return talkList;
    }
}
