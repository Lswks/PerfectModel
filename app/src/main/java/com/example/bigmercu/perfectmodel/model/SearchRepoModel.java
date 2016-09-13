package com.example.bigmercu.perfectmodel.model;

import com.trello.rxlifecycle.android.ActivityEvent;

import rx.subjects.BehaviorSubject;

/**
 * Created by bigmercu on 2016/9/7.
 * Email: bigmercu@gmail.com
 */

public interface SearchRepoModel {
    void searchRepoModel(String repoName, BehaviorSubject<ActivityEvent> lifecycle, UserInfoModel.onGetDataListener listener);
}
