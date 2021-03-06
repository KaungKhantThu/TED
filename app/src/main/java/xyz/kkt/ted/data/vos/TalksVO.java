package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/24/2018.
 */
@Entity(tableName = TEDConstants.TED_TALK_TABLE_NAME)//table name py tr
@TypeConverters(TagTypeConverter.class)
public class TalksVO {

    @PrimaryKey(autoGenerate = true)
    private long talkTedId;

    @SerializedName("description")
    private String description;

    @SerializedName("durationInSec")
    private int durationInSec;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("speaker")
    @Embedded
    private SpeakerVO speaker;

    @SerializedName("tag")
    private List<TagVO> tagList;

    @SerializedName("talk_id")
    private int talkId;

    @SerializedName("title")
    private String title;


    public long getTalkTedId() {
        return talkTedId;
    }

    public void setTalkTedId(long talkTedId) {
        this.talkTedId = talkTedId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public void setSpeaker(SpeakerVO speaker) {
        this.speaker = speaker;
    }

    public List<TagVO> getTagList() {
        return tagList;
    }

    public void setTagList(List<TagVO> tagList) {
        this.tagList = tagList;
    }

    public int getTalkId() {
        return talkId;
    }

    public void setTalkId(int talkId) {
        this.talkId = talkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
