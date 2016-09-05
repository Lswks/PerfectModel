package com.example.bigmercu.perfectmodel.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.bigmercu.perfectmodel.util.ContextHolder;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */

public final class GithubUserHepler extends SQLiteOpenHelper {

    private static final String TAG = GithubUserHepler.class.getSimpleName();

    private static final String DB_NAME = "GithubUserDB";
    private static final int DATABASE_VERSION = 1;

    private static GithubUserHepler mGithubUserHepler;

    public GithubUserHepler(Context context) {
        super(context, DB_NAME, null, DATABASE_VERSION);
    }

    public static GithubUserHepler gitInstance(){
        return GithubUserHeplerInstanceHolder.hepler;
    }

    public static class GithubUserHeplerInstanceHolder{
        private static GithubUserHepler hepler = new GithubUserHepler(ContextHolder.getContext());
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,GithubUser.CREATE_TABLE);
        sqLiteDatabase.execSQL(GithubUser.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d(TAG,"upgrade");
    }
}
