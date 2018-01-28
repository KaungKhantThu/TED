package xyz.kkt.ted.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.Observable;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.kkt.ted.TEDApp;
import xyz.kkt.ted.data.db.AppDatabase;
import xyz.kkt.ted.data.vos.PlaylistVO;
import xyz.kkt.ted.data.vos.PodcastVO;
import xyz.kkt.ted.data.vos.SearchVO;
import xyz.kkt.ted.data.vos.TalksVO;
import xyz.kkt.ted.network.apis.TEDAPI;
import xyz.kkt.ted.network.responses.PlaylistResponse;
import xyz.kkt.ted.network.responses.PodcastResponse;
import xyz.kkt.ted.network.responses.SearchResponse;
import xyz.kkt.ted.network.responses.TalksResponse;
import xyz.kkt.ted.utils.TEDConstants;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by Lenovo on 1/24/2018.
 */

public class TEDModel extends ViewModel {

    private AppDatabase mAppDatabase;

    private TEDAPI theApi;

    public TEDModel() {
        initRestaurantApi();
    }

    public TEDAPI getTEDApi() {
        return theApi;
    }

    private void initRestaurantApi() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(TEDConstants.TED_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(TEDAPI.class);
    }

    public void initDatabase(Context context) {
        mAppDatabase = AppDatabase.getInDatabase(context);
    }

    public LiveData<List<TalksVO>> getTalks() {
        return mAppDatabase.talksDao().getAllTedTalks();
    }

    public LiveData<List<PlaylistVO>> getTedPlayList() {
        return mAppDatabase.talksDao().getAllTedPlayList();
    }

    public LiveData<List<PodcastVO>> getTedPodCastList() {
        return mAppDatabase.talksDao().getAllTedPodCast();
    }

    public TalksVO getTedTalkByID(long tedTalkId) {
        return mAppDatabase.talksDao().getTedTalksById(tedTalkId);
    }

    public PlaylistVO getTedPlayListByID(long tedPlayListId) {
        return mAppDatabase.talksDao().getTedPlayListById(tedPlayListId);
    }

    public PodcastVO getTedPodCastByID(long tedPodCastId) {
        return mAppDatabase.talksDao().getTedPodCastById(tedPodCastId);
    }

    public LiveData<List<SearchVO>> getSearchDataByValue(String searchValue, String resultType) {
        return mAppDatabase.talksDao().getSearchDataByValue(searchValue, resultType);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        AppDatabase.destroyInstance();
    }

    public void callTalkApi() {
        Observable<TalksResponse> talksResponseObservable = getTalkListResponseObservable();
        talksResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Consumer<TalksResponse>() {
                    @Override
                    public void accept(TalksResponse talksResponse) throws Exception {
                        mAppDatabase.talksDao().deleteTedTalk();
                        long[] insertedIds = mAppDatabase.talksDao().insertTedTalks(talksResponse.getTalkList().toArray(new TalksVO[0]));
                        Log.d(TEDApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void callPlaylistApi() {
        Observable<PlaylistResponse> playlistResponseObservable = getPlaylistResponseObservable();
        playlistResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Consumer<PlaylistResponse>() {
                    @Override
                    public void accept(PlaylistResponse playlistResponse) throws Exception {
                        mAppDatabase.talksDao().deleteTedPlaylist();
                        long[] insertedIds = mAppDatabase.talksDao().insertTedPlayList(playlistResponse.getPlaylists().toArray(new PlaylistVO[0]));
                        Log.d(TEDApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void callPodcastApi() {
        Observable<PodcastResponse> podcastResponseObservable = getPodcastResponseObservable();
        podcastResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Consumer<PodcastResponse>() {
                    @Override
                    public void accept(PodcastResponse tedPodCastsResponse) throws Exception {
                        mAppDatabase.talksDao().deleteTedPodCast();
                        long[] insertedIds = mAppDatabase.talksDao().insertTedPodCast(tedPodCastsResponse.getPodcastList().toArray(new PodcastVO[0]));
                        Log.d(TEDApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void callSearchApi() {
        Observable<SearchResponse> searchResponseObservable = getSearchResponseObservable();
        searchResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Consumer<SearchResponse>() {
                    @Override
                    public void accept(SearchResponse searchResponse) throws Exception {
                        mAppDatabase.talksDao().deleteTedSearch();
                        long[] insertedIds = mAppDatabase.talksDao().insertTedSearch(searchResponse.getResultList().toArray(new SearchVO[0]));
                        Log.d(TEDApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    private io.reactivex.Observable<TalksResponse> getTalkListResponseObservable() {
        return getTEDApi().getTalkList(TEDConstants.PAGE_NO, TEDConstants.ACCESS_TOKEN);
    }

    private io.reactivex.Observable<PlaylistResponse> getPlaylistResponseObservable() {
        return getTEDApi().getPlaylistList(TEDConstants.PAGE_NO, TEDConstants.ACCESS_TOKEN);
    }

    private io.reactivex.Observable<PodcastResponse> getPodcastResponseObservable() {
        return getTEDApi().getPodcastList(TEDConstants.PAGE_NO, TEDConstants.ACCESS_TOKEN);
    }

    private io.reactivex.Observable<SearchResponse> getSearchResponseObservable() {
        return getTEDApi().getSearchList(TEDConstants.PAGE_NO, TEDConstants.ACCESS_TOKEN);
    }
}

