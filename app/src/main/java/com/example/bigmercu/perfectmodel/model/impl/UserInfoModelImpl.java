package com.example.bigmercu.perfectmodel.model.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.bigmercu.perfectmodel.entity.UserInfoEntity;
import com.example.bigmercu.perfectmodel.model.UserInfoModel;
import com.example.bigmercu.perfectmodel.model.api.UserInfoService;
import com.example.bigmercu.perfectmodel.model.db.GithubUser;
import com.example.bigmercu.perfectmodel.model.db.GithubUserHepler;
import com.example.bigmercu.perfectmodel.util.MyAdapterFactory;
import com.example.bigmercu.perfectmodel.util.RetrofitClient;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
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
    private SQLiteDatabase mSQLiteDatabase;
    private UserInfoService mUserInfoService;
    Gson mGson=  new GsonBuilder().registerTypeAdapterFactory(MyAdapterFactory.create())
                                .create();

    public static UserInfoModelImpl getInstance(){
        return UserInfoModelImplInstanceHolder.userInfoModel;
    }

    public static class UserInfoModelImplInstanceHolder{
        private static UserInfoModelImpl userInfoModel = new UserInfoModelImpl();
    }

    public UserInfoModelImpl(){
        mUserInfoService = RetrofitClient.getInstance().create(UserInfoService.class);
//        mSQLiteDatabase = SQLiteDatabase.openOrCreateDatabase("GithubUser.db",);
    }

    @Override
    public void getUserInfo(String name) {
        mUserInfoService.getUserInfo(name)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<ResponseBody, UserInfoEntity>() {
                    @Override
                    public UserInfoEntity call(ResponseBody responseBody) {
                        try {
                            return mGson.fromJson(responseBody.string(),UserInfoEntity.class);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }).subscribe(new Action1<UserInfoEntity>() {
            @Override
            public void call(UserInfoEntity userInfoEntity) {
                SQLiteDatabase db = GithubUserHepler.gitInstance().getWritableDatabase();
                insert(db,userInfoEntity);
                db.close();
                List<GithubUser> list = new ArrayList<GithubUser>();
                SQLiteDatabase db1 = GithubUserHepler.gitInstance().getReadableDatabase();
                list = query(db1,"Bigmercu");
                Log.d(TAG,list.toString());
            }
        });
    }


    public void insert(SQLiteDatabase mDb, UserInfoEntity mUser){
        mDb.insert(GithubUser.TABLE_NAME,null,GithubUser.FACTORY.marshal()
                .avatar_url(mUser.avatar_url())
                .bio(mUser.bio())
                .blog(mUser.blog())
                .email(mUser.email())
                .followers(mUser.followers())
                .following(mUser.following())
                .id(mUser.id())
                .location(mUser.location())
                .created_at(mUser.created_at())
                .name(mUser.name())
                .public_repos(mUser.public_repos())
                .login(mUser.login())
                .url(mUser.url())
                .repos_url(mUser.repos_url())
                .asContentValues());
    }

    public List<GithubUser> query(SQLiteDatabase db,String name){
        List<GithubUser> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(GithubUser.SELECT_BY_LOGIN,new String[]{name});
        while (cursor.moveToNext()){
            list.add(GithubUser.MAPPER.map(cursor));
        }
        return list;
    }

}
