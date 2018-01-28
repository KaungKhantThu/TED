package xyz.kkt.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.kkt.ted.data.vos.TagVO;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by aung on 7/28/17.
 */

@Dao
public interface TagsDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTag(TagVO tag);//Data type is the same as that of primary key

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTags(TagVO... tags);//Data type is the same as that of primary key

    @Query("SELECT * FROM tags")
    LiveData<List<TagVO>> getAllTags();

    @Query("DELETE FROM tags")
    void deleteAll();
}
