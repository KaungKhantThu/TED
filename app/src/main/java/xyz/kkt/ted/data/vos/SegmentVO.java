package xyz.kkt.ted.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/27/2018.
 */

public class SegmentVO {

    @SerializedName("segment_id")
    private int segmentId;

    @SerializedName("title")
    private String title;

    @SerializedName("imageUrl")
    private String imageUrl;

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
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
}
