package com.example.bigmercu.perfectmodel.base;

import com.trello.rxlifecycle.android.ActivityEvent;

import rx.subjects.BehaviorSubject;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public interface BaseView<T> {
    void setPresenter(T presenter);
    BehaviorSubject<ActivityEvent> lifecycle = BehaviorSubject.create();
}
