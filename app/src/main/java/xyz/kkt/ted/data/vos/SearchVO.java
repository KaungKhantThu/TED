package xyz.kkt.ted.data.vos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by Lenovo on 1/27/2018.
 */

@Entity(tableName = TEDConstants.TED_SEARCH_TABLE_NAME)
public class SearchVO {

    @PrimaryKey(autoGenerate = true)
    private long searchTedId;

    @SerializedName("description")
    private String description;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("result_id")
    private int resultId;

    @SerializedName("result_type")
    private String resultType;

    @SerializedName("search_result_id")
    private int searchResultId;

    @SerializedName("title")
    private String title;

    public long getSearchTedId() {
        return searchTedId;
    }

    public void setSearchTedId(long searchTedId) {
        this.searchTedId = searchTedId;
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

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }

    public int getSearchResultId() {
        return searchResultId;
    }

    public void setSearchResultId(int searchResultId) {
        this.searchResultId = searchResultId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}