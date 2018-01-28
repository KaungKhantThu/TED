package xyz.kkt.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.kkt.ted.data.vos.SpeakerVO;
import xyz.kkt.ted.data.vos.TalksVO;

/**
 * Created by aung on 7/28/17.
 */

@Dao
public interface SpeakersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertSpeaker(SpeakerVO speaker);//Data type is the same as that of primary key

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertSpeakers(SpeakerVO... speakers);//Data type is the same as that of primary key

    @Query("SELECT * FROM speakers")
    LiveData<List<SpeakerVO>> getAllSpeakers();

    @Query("DELETE FROM speakers")
    void deleteAll();
}
