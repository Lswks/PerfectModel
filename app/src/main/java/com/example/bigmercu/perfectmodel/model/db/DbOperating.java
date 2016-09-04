package com.example.bigmercu.perfectmodel.model.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bigmercu.perfectmodel.GithubUserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */

public class DbOperating {

    public void insert(SQLiteDatabase mDb, GithubUserModel mUser) {
        mDb.insert(GithubUser.TABLE_NAME, null, GithubUser.FACTORY.marshal()
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

    public List<GithubUser> query(SQLiteDatabase db, String name) {
        List<GithubUser> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(GithubUser.SELECT_BY_LOGIN, new String[]{name});
        while (cursor.moveToNext()) {
            list.add(GithubUser.MAPPER.map(cursor));
        }
        return list;
    }
}
