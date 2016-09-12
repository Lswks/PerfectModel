package com.example.bigmercu.perfectmodel.model.impl;

import android.util.Log;

import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.model.SearchRepoModel;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.api.SearchRepoService;
import com.example.bigmercu.perfectmodel.util.RetrofitClient;
import com.google.gson.Gson;
import com.socks.library.KLog;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */

public class SearchRepoModelImpl implements SearchRepoModel {

    private SearchRepoService mSearchRepoService;
    private Gson mGson;
    private SearchEntry mSearchEntry;
    private static final String TAG = SearchRepoModelImpl.class.getSimpleName();

    public static SearchRepoModelImpl getInstance() {
        return SearchRepoModelImplInstanceHolder.searchRepoModel;
    }

    public static class SearchRepoModelImplInstanceHolder {
        private static SearchRepoModelImpl searchRepoModel = new SearchRepoModelImpl();
    }

    public SearchRepoModelImpl() {
        mSearchRepoService = RetrofitClient.getInstance().create(SearchRepoService.class);
        mGson = new Gson();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void searchRepoModel(String repoName, final UserInfoModel.onGetDataListener listener) {

        mSearchRepoService.searchRepo(repoName)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SearchEntry>() {
                    @Override
                    public void call(SearchEntry searchEntry) {
                        Log.d(TAG,searchEntry.toString());
                        listener.onSuccess(searchEntry);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        KLog.e(throwable.getMessage());
                        listener.onFiled(throwable.getMessage());
                    }
                });
    }
}
