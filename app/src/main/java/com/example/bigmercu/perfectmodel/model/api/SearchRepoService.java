package com.example.bigmercu.perfectmodel.model.api;

import com.example.bigmercu.perfectmodel.entry.SearchEntry;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */

public interface SearchRepoService {

    @GET("search/repositories")
    Observable<SearchEntry> searchRepo(@Query("q") String repo);
}
