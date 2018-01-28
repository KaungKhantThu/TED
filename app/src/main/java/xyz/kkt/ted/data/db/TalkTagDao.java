package xyz.kkt.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.kkt.ted.data.vos.TalkTagVO;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by aung on 7/28/17.
 */

@Dao
public interface TalkTagDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTalkTag(TalkTagVO talkTagVO);//Data type is the same as that of primary key

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTalkTags(TalkTagVO... talkTagVOs);//Data type is the same as that of primary key

    @Query("SELECT * FROM talk_tag")
    List<TalkTagVO> getAllTalkTag();

    @Query("DELETE FROM talk_tag")
    void deleteAll();
}
