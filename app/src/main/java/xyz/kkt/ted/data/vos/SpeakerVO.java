package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/25/2018.
 */
@Entity(tableName = TEDConstants.TED_TALK_SPEAKER_TABLE_NAME)//table name py tr
public class SpeakerVO {

    @PrimaryKey(autoGenerate = true)
    private long speakerTedId;

    @SerializedName("name")
    private String name;
    @SerializedName("speaker_id")
    private int speakerId;

    public long getSpeakerTedId() {
        return speakerTedId;
    }

    public void setSpeakerTedId(long speakerTedId) {
        this.speakerTedId = speakerTedId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }
}
