package xyz.kkt.ted.network.apis;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.kkt.ted.network.responses.PlaylistResponse;
import xyz.kkt.ted.network.responses.PodcastResponse;
import xyz.kkt.ted.network.responses.SearchResponse;
import xyz.kkt.ted.network.responses.TalksResponse;
import xyz.kkt.ted.utils.TEDConstants;

/**
 * Created by aung on 7/13/17.
 */

public interface TEDAPI {

    @FormUrlEncoded
    @POST(TEDConstants.API_GET_TALKS_V2)
    Observable<TalksResponse> getTalkList(

            @Field("page")
                    String pageIndex,
            @Field("access_token")
                    String accessToken);

    @FormUrlEncoded
    @POST(TEDConstants.API_GET_PLAYLISTS_V2)
    Observable<PlaylistResponse> getPlaylistList(

            @Field("page")
                    String pageIndex,
            @Field("access_token")
                    String accessToken);

    @FormUrlEncoded
    @POST(TEDConstants.API_GET_PODCASTS_V2)
    Observable<PodcastResponse> getPodcastList(

            @Field("page")
                    String pageIndex,
            @Field("access_token")
                    String accessToken);

    @FormUrlEncoded
    @POST(TEDConstants.API_GET_SEARCH_V2)
    Observable<SearchResponse> getSearchList(

            @Field("page")
                    String pageIndex,
            @Field("access_token")
                    String accessToken);

}
