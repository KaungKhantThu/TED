package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Lenovo on 1/25/2018.
 */
@Entity(tableName = "tags")
public class TagVO {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("tag_id")
    private int tagId;

    @SerializedName("tag")
    private String tag;

    @SerializedName("description")
    private String description;

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTagId() {
        return tagId;
    }

    public String getTag() {
        return tag;
    }

    public String getDescription() {
        return description;
    }

}
