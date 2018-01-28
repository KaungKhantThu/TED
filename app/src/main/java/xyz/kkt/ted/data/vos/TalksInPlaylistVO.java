
package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import xyz.kkt.ted.utils.TEDConstants;

@Entity(tableName = TEDConstants.TALK_PLAY_LIST_TABLE_NAME)//table name py tr
public class TalksInPlaylistVO {

    @PrimaryKey(autoGenerate = true)
    private long talksInPlaylistTedId;

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
    private List<TagVO> tag;

    @SerializedName("talk_id")
    private int talkId;

    @SerializedName("title")
    private String title;

    public long getTalksInPlaylistTedId() {
        return talksInPlaylistTedId;
    }

    public void setTalksInPlaylistTedId(long talksInPlaylistTedId) {
        this.talksInPlaylistTedId = talksInPlaylistTedId;
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

    public List<TagVO> getTag() {
        return tag;
    }

    public void setTag(List<TagVO> tag) {
        this.tag = tag;
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
