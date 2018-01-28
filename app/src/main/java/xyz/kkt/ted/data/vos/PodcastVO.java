package xyz.kkt.ted.data.vos;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class PodcastVO {

    @SerializedName("podcast_id")
    private int podcastId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("segments")
    private List<SegmentVO> segmentList;

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SegmentVO> getSegmentList() {
        return segmentList;
    }

    public void setSegmentList(List<SegmentVO> segmentList) {
        this.segmentList = segmentList;
    }
}
