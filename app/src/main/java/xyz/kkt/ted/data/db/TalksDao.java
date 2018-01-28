package xyz.kkt.ted.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.PodcastVO;
import xyz.kkt.ted.data.vos.SearchVO;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by aung on 7/28/17.
 */

@Dao
public interface TalksDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertTedTalks(TalksVO tedTalkVO);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedTalks(TalksVO... tedTalkVOS);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedPlayList(PlaylistVO... tedPlaylistVOS);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedPodCast(PodcastVO... tedPodcastsVOS);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long[] insertTedSearch(SearchVO... resultsVO);


    @Query("SELECT * FROM " + TEDConstants.TED_TALK_TABLE_NAME)
    LiveData<List<TalksVO>> getAllTedTalks();

    @Query("SELECT * FROM " + TEDConstants.TED_SEARCH_TABLE_NAME + " WHERE title LIKE :searchValue OR resultType LIKE :resultType")
    LiveData<List<SearchVO>> getSearchDataByValue(String searchValue, String resultType);

    @Query("SELECT * FROM " + TEDConstants.TED_TALK_TABLE_NAME + " WHERE talkId = :tedTalkId LIMIT 1")
    TalksVO getTedTalksById(long tedTalkId);

    @Query("SELECT * FROM " + TEDConstants.TED_PLAY_LIST_TABLE_NAME + " WHERE playlistId = :tedPlayListId LIMIT 1")
    PlaylistVO getTedPlayListById(long tedPlayListId);

    @Query("SELECT * FROM " + TEDConstants.TED_POD_CAST_TABLE_NAME + " WHERE podcastId = :tedPodCastId LIMIT 1")
    PodcastVO getTedPodCastById(long tedPodCastId);

    @Query("SELECT * FROM " + TEDConstants.TED_PLAY_LIST_TABLE_NAME)
    LiveData<List<PlaylistVO>> getAllTedPlayList();

    @Query("SELECT * FROM " + TEDConstants.TED_POD_CAST_TABLE_NAME)
    LiveData<List<PodcastVO>> getAllTedPodCast();

    @Query("DELETE FROM " + TEDConstants.TED_TALK_TABLE_NAME)
    void deleteTedTalk();

    @Query("DELETE FROM " + TEDConstants.TED_PLAY_LIST_TABLE_NAME)
    void deleteTedPlaylist();

    @Query("DELETE FROM " + TEDConstants.TED_POD_CAST_TABLE_NAME)
    void deleteTedPodCast();

    @Query("DELETE FROM " + TEDConstants.TED_SEARCH_TABLE_NAME)
    void deleteTedSearch();

}
