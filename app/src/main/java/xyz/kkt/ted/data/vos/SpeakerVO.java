package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/25/2018.
 */
@Entity(tableName = "speakers")
public class SpeakerVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("speaker_id")
    private int speakerId;

    @SerializedName("name")
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setSpeakerId(int speakerId) {
        this.speakerId = speakerId;
    }

    public int getSpeakerId() {
        return speakerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
