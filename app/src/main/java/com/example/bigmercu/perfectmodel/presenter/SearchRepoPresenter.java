package com.example.bigmercu.perfectmodel.presenter;

import com.example.bigmercu.perfectmodel.contract.SearchRepoContract;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.impl.SearchRepoModelImpl;
import com.socks.library.KLog;

/**
 * Created by bigmercu on 2016/9/8.
 * Email: bigmercu@gmail.com
 */

public class SearchRepoPresenter implements SearchRepoContract.SearchRepoPresenter,UserInfoModel.onGetDataListener{

    private SearchRepoContract.SearchRepoView mSearchRepoView;
    private SearchRepoModelImpl mSearchRepoModel;

    public SearchRepoPresenter(SearchRepoContract.SearchRepoView view){
        this.mSearchRepoView = view;
        mSearchRepoModel = SearchRepoModelImpl.getInstance();
        view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void searchRepo(String repoName) {
        mSearchRepoModel.searchRepoModel(repoName,this);
    }


    @Override
    public void onSuccess(Object entry) {
        SearchEntry searchEntry = (SearchEntry) entry;
        KLog.d(searchEntry.toString());
    }

    @Override
    public void onFiled(String msg) {
        KLog.e(msg);
    }
}
