package xyz.kkt.ted.data.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import io.reactivex.Observable;
import io.reactivex.Observer;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.kkt.ted.TEDApp;
import xyz.kkt.ted.activities.SearchActivity;
import xyz.kkt.ted.data.db.AppDatabase;
import xyz.kkt.ted.data.vos.SpeakerVO;
import xyz.kkt.ted.data.vos.TagVO;
import xyz.kkt.ted.data.vos.TalkTagVO;
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
        return mAppDatabase.talksDao().getAllTalks();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
//        AppDatabase.destroyInstance();
    }

//    @Subscribe(threadMode = ThreadMode.BACKGROUND)
//    public void onAttractionsLoadedEvent(DataEvent.AttractionsLoadedEvent event) {
//        mAppDatabase.attractionsDao().deleteAll();
//        long[] insertedIds = mAppDatabase.attractionsDao().insertAttractions(event.getAttractionList().toArray(new AttractionVO[0]));
//        Log.d(MAApp.TAG, "Total inserted count : " + insertedIds.length);
//    }

    public void callTalkApi() {
        Observable<TalksResponse> talksResponseObservable = getTalkListResponseObservable();
        talksResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Consumer<TalksResponse>() {
                    @Override
                    public void accept(TalksResponse talksResponse) throws Exception {
                        mAppDatabase.talksDao().deleteAll();
                        long[] insertedIds = mAppDatabase.talksDao().insertTalks(talksResponse.getTalkList().toArray(new TalksVO[0]));
                        Log.d(TEDApp.TAG, "Total inserted count : " + insertedIds.length);
                    }
                });
    }

    public void callPlaylistApi() {
        Observable<PlaylistResponse> playlistResponseObservable = getPlaylistResponseObservable();
        playlistResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Observer<PlaylistResponse>() {

                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull PlaylistResponse playlistResponse) {
                        //TODO store data
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.d(TEDApp.TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void callPodcastApi() {
        Observable<PodcastResponse> podcastResponseObservable = getPodcastResponseObservable();
        podcastResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Observer<PodcastResponse>() {

                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull PodcastResponse podcastResponse) {
                        //TODO store data
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.d(TEDApp.TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void callSearchApi() {
        Observable<SearchResponse> searchResponseObservable = getSearchResponseObservable();
        searchResponseObservable
                .subscribeOn(Schedulers.io()) //run value creation code on a specific thread (non-UI thread) (defining where data insertion is done)
                .observeOn(AndroidSchedulers.mainThread()) //observe the emitted value of the Observable on an appropriate thread
                .subscribe(new Observer<SearchResponse>() {

                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull SearchResponse searchResponse) {
                        //TODO store data
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {
                        Log.d(TEDApp.TAG, e.getMessage());
                    }

                    @Override
                    public void onComplete() {

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

