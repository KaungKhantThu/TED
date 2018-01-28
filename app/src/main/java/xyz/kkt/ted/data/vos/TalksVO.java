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

/**
 * Created by Lenovo on 1/24/2018.
 */
@Entity(tableName = "talks", foreignKeys = @ForeignKey(entity = SpeakerVO.class,
        parentColumns = "id",
        childColumns = "speaker_id_in_talk"))
//@TypeConverters(TagTypeConverter.class)
public class TalksVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "speaker_id_in_talk")
    private int speaker_id_in_talk;

    @SerializedName("talk_id")
    private int titleId;

    @SerializedName("title")
    private String title;

    @Ignore
    @SerializedName("speaker")
    private SpeakerVO speaker;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("durationInSec")
    private int durationInSec;

    @SerializedName("description")
    private String description;

    @Ignore
    @SerializedName("tag")
    private List<TagVO> tags;

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSpeaker(SpeakerVO speaker) {
        this.speaker = speaker;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDurationInSec(int durationInSec) {
        this.durationInSec = durationInSec;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TagVO> getTags() {
        return tags;
    }

    public void setTags(List<TagVO> tags) {
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getSpeakerIdInTalk() {
        return speaker_id_in_talk;
    }

    public void setSpeakerIdInTalk(int speakerIdInTalk) {
        this.speaker_id_in_talk = speakerIdInTalk;
    }

    public int getTitleId() {
        return titleId;
    }

    public String getTitle() {
        return title;
    }

    public SpeakerVO getSpeaker() {
        return speaker;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getDurationInSec() {
        return durationInSec;
    }

    public String getDescription() {
        return description;
    }

    public int getSpeaker_id_in_talk() {
        return speaker_id_in_talk;
    }

    public void setSpeaker_id_in_talk(int speaker_id_in_talk) {
        this.speaker_id_in_talk = speaker_id_in_talk;
    }

    public static List<TalksVO> insertSpeakerIdInTalk(List<TalksVO> talkList) {
        for (TalksVO talk : talkList) {
            talk.speaker_id_in_talk = talk.getSpeaker().getSpeakerId();
        }
        return talkList;
    }

    public static List<TagVO> toInsertTags(List<TalksVO> talkList) {
        List<TagVO> tagList = new ArrayList<>();
        for (TalksVO talk : talkList) {
            tagList.addAll(talk.getTags());
        }
        return tagList;
    }

}
