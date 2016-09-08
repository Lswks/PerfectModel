package com.example.bigmercu.perfectmodel.model.api;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */

public interface SearchRepoService {

    @GET("search/repositories")
    Observable<ResponseBody> searchRepo(@Query("q") String repo);
}
