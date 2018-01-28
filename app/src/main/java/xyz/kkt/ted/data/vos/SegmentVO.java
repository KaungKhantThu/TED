package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/27/2018.
 */

@Entity(tableName = TEDConstants.TED_SEGMENT_TABLE_NAME)
public class SegmentVO {

    @PrimaryKey(autoGenerate = true)
    private long segmentTedId;

    @SerializedName("imageUrl")
    private String imageUrl;
    @SerializedName("segment_id")
    private int segmentId;
    @SerializedName("title")
    private String title;



    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getSegmentTedId() {
        return segmentTedId;
    }

    public void setSegmentTedId(long segmentTedId) {
        this.segmentTedId = segmentTedId;
    }

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
}
