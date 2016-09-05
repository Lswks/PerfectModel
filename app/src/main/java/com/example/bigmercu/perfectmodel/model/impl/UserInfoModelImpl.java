package com.example.bigmercu.perfectmodel.model.impl;

import android.database.Cursor;
import android.util.Log;

import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.api.UserInfoService;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;
import com.example.bigmercu.perfectmodel.model.db.GithubUserHepler;
import com.example.bigmercu.perfectmodel.util.ApiErrorEntry;
import com.example.bigmercu.perfectmodel.util.MyAdapterFactory;
import com.example.bigmercu.perfectmodel.util.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by bigmercu on 2016/9/3.
 * Email: bigmercu@gmail.com
 */

public class UserInfoModelImpl implements UserInfoModel {

    private static final String TAG = UserInfoModelImpl.class.getSimpleName();
    private UserInfoService mUserInfoService;
    private Gson mGson;
    private BriteDatabase mBriteDatabase;
    private GithubUser mGithubUser;
    private Subscription mLocalDataSubscription;
    private Subscription mRemoteDataSubscription;

    public static UserInfoModelImpl getInstance() {
        return UserInfoModelImplInstanceHolder.userInfoModel;
    }

    public static class UserInfoModelImplInstanceHolder {
        private static UserInfoModelImpl userInfoModel = new UserInfoModelImpl();
    }

    public UserInfoModelImpl() {
        mUserInfoService = RetrofitClient.getInstance().create(UserInfoService.class);
        mGson = new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create()).create();

        SqlBrite sqlBrite = SqlBrite.create();

        mBriteDatabase = sqlBrite.wrapDatabaseHelper(GithubUserHepler.gitInstance(),Schedulers.io());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void getUserInfo(final String name, final onGetDataListener listener) {
        //TODO 缓存策略 优化代码
        final boolean[] isUpdate = {false};

        mLocalDataSubscription = mBriteDatabase
                .createQuery(GithubUser.TABLE_NAME, GithubUser.SELECT_BY_LOGIN, new String[]{name})
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<SqlBrite.Query>() {
                    @Override
                    public void call(SqlBrite.Query query) {
                        Cursor cursor = query.run();
                        while (cursor.moveToNext()) {
                            mGithubUser = GithubUser.MAPPER.map(cursor);
                        }
                        if(mGithubUser != null){
                            listener.onSuccess(mGithubUser);
                        }
                    }
                });

        mRemoteDataSubscription = mUserInfoService.getUserInfo(name)
                 .subscribeOn(Schedulers.io())
                 .map(new Func1<ResponseBody,GithubUser>() {
                     @Override
                     public GithubUser call(ResponseBody responseBody) {
                         try {
                             return mGson.fromJson(responseBody.string(), GithubUser.class);
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                         return null;
                     }
                 })
                 .doOnNext(new Action1<GithubUser>() {
                     @Override
                     public void call(GithubUser githubUser) {
                         if(mGithubUser != null){
                             mBriteDatabase.update(GithubUser.TABLE_NAME,GithubUser.FACTORY.marshal()
                                     .avatar_url(githubUser.avatar_url())
                                     .bio(githubUser.bio())
                                     .blog(githubUser.blog())
                                     .email(githubUser.email())
                                     .followers(githubUser.followers())
                                     .following(githubUser.following())
                                     .location(githubUser.location())
                                     .created_at(githubUser.created_at())
                                     .name(githubUser.name())
                                     .public_repos(githubUser.public_repos())
                                     .login(githubUser.login())
                                     .url(githubUser.url())
                                     .repos_url(githubUser.repos_url())
                                     .asContentValues(),"id=?", String.valueOf(githubUser.id()));
                         }else {
                             mBriteDatabase.insert(GithubUser.TABLE_NAME,GithubUser.FACTORY.marshal()
                                     .avatar_url(githubUser.avatar_url())
                                     .bio(githubUser.bio())
                                     .blog(githubUser.blog())
                                     .email(githubUser.email())
                                     .followers(githubUser.followers())
                                     .following(githubUser.following())
                                     .id(githubUser.id())
                                     .location(githubUser.location())
                                     .created_at(githubUser.created_at())
                                     .name(githubUser.name())
                                     .public_repos(githubUser.public_repos())
                                     .login(githubUser.login())
                                     .url(githubUser.url())
                                     .repos_url(githubUser.repos_url())
                                     .asContentValues());
                         }
                     }
                 })
                 .unsubscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new Subscriber<GithubUser>() {
                     @Override
                     public void onCompleted() {

                     }
                     @Override
                     public void onError(Throwable e) {
                         if(e instanceof HttpException){
                             HttpException exception = (HttpException) e;
                             ApiErrorEntry apiErrorEntry = null;
                             try {
                                 apiErrorEntry = mGson.fromJson(exception
                                         .response()
                                         .errorBody()
                                         .string(),
                                         ApiErrorEntry.class);
                                 listener.onFiled(apiErrorEntry.toString());
                             } catch (IOException e1) {
                                 e1.printStackTrace();
                             }
                         }
                     }
                     @Override
                     public void onNext(GithubUser githubUser) {
                         Log.d(TAG,githubUser.toString());
                     }
                 });
    }

    @Override
    public void onCancle() {
        if(mLocalDataSubscription != null && !mLocalDataSubscription.isUnsubscribed()){
            mLocalDataSubscription.unsubscribe();
        }

        if(mRemoteDataSubscription != null && !mRemoteDataSubscription.isUnsubscribed()){
            mLocalDataSubscription.unsubscribe();
        }
        mBriteDatabase.close();
        mGson = null;
        mGithubUser = null;
    }
}
