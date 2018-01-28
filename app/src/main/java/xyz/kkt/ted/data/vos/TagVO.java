package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/25/2018.
 */
@Entity(tableName = TEDConstants.TED_TALK_TAG_TABLE_NAME)//table name py tr
public class TagVO {

    @PrimaryKey(autoGenerate = true)
    private long tagTedId;

    @SerializedName("description")
    private String description;
    @SerializedName("tag")
    private String tag;
    @SerializedName("tag_id")
    private int taagId;

    public long getTagTedId() {
        return tagTedId;
    }

    public void setTagTedId(long tagTedId) {
        this.tagTedId = tagTedId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getTaagId() {
        return taagId;
    }

    public void setTaagId(int taagId) {
        this.taagId = taagId;
    }
}
