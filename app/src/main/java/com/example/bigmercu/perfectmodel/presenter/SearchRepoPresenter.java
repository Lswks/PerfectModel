package com.example.bigmercu.perfectmodel.presenter;

import android.util.Log;

import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.impl.SearchRepoModelImpl;
import com.socks.library.KLog;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.trello.rxlifecycle.android.RxLifecycleAndroid;

import java.util.List;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;

/**
 * Created by bigmercu on 2016/9/8.
 * Email: bigmercu@gmail.com
 */

public class SearchRepoPresenter implements SearchRepoContract.SearchRepoPresenter,UserInfoModel.onGetDataListener{

    private SearchRepoContract.SearchRepoView mSearchRepoView;
    private SearchRepoModelImpl mSearchRepoModel;
    private BehaviorSubject<ActivityEvent> lifecycle;

    public SearchRepoPresenter(SearchRepoContract.SearchRepoView view,BehaviorSubject<ActivityEvent> lifecycle){
        this.mSearchRepoView = view;
        mSearchRepoModel = SearchRepoModelImpl.getInstance();
        this.lifecycle = lifecycle;
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void searchRepo(String repoName) {
        mSearchRepoModel.searchRepoModel(repoName ,lifecycle,this);
    }


    @Override
    public void onSuccess(Object entry) {
        Observable.just(entry)
                .compose(RxLifecycleAndroid.bindActivity(lifecycle))
                .map(new Func1<Object, List<SearchEntry.ItemsBean>>() {
                    @Override
                    public List<SearchEntry.ItemsBean> call(Object searchEntry) {
                        if(searchEntry != null && ((SearchEntry)searchEntry).items() != null){
                            return ((SearchEntry)searchEntry).items();
                        }
                        return null;
                    }
                }).subscribe(new Action1<List<SearchEntry.ItemsBean>>() {
            @Override
            public void call(List<SearchEntry.ItemsBean> itemsBeen) {
                Log.d("TAG","success");
                mSearchRepoView.onGetRepoData(itemsBeen);
            }
        });
    }

    @Override
    public void onFiled(String msg) {
        KLog.e(msg);
    }
}
