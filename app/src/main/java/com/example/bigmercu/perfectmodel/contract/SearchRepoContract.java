package com.example.bigmercu.perfectmodel.contract;

import com.example.bigmercu.perfectmodel.base.BasePresenter;
import com.example.bigmercu.perfectmodel.base.BaseView;
import com.example.bigmercu.perfectmodel.entry.SearchEntry;

import java.util.List;

/**
 * Created by bigmercu on 2016/9/8.
 * Email: bigmercu@gmail.com
 */

public interface SearchRepoContract{
    interface SearchRepoPresenter extends BasePresenter{
        void searchRepo(String repoName);
    }

    interface SearchRepoView extends BaseView<SearchRepoContract.SearchRepoPresenter>{
        void onGetRepoData(List<SearchEntry.ItemsBean> list);
        void onFiled(String msg);
    }
}
