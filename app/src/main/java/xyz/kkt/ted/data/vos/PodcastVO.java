package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import xyz.kkt.ted.utils.TEDConstants;


/**
 * Created by Lenovo on 1/24/2018.
 */


@Entity(tableName = TEDConstants.TED_POD_CAST_TABLE_NAME)//table name py tr
@TypeConverters(SegmentTypeConverter.class)
public class PodcastVO {

    @PrimaryKey(autoGenerate = true)
    private long podcastTedId;

    @SerializedName("description")
    private String description;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("podcast_id")
    private int podcastId;

    @SerializedName("segments")
    private List<SegmentVO> segmentList;

    @SerializedName("title")
    private String title;

    public long getPodcastTedId() {
        return podcastTedId;
    }

    public void setPodcastTedId(long podcastTedId) {
        this.podcastTedId = podcastTedId;
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

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public List<SegmentVO> getSegmentList() {
        return segmentList;
    }

    public void setSegmentList(List<SegmentVO> segmentList) {
        this.segmentList = segmentList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
