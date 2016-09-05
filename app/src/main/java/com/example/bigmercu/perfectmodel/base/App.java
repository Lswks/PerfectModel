package com.example.bigmercu.perfectmodel.base;

import android.app.Application;

import com.example.bigmercu.perfectmodel.util.ContextHolder;
import com.facebook.stetho.Stetho;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.initial(this);
        Stetho.initializeWithDefaults(this);
    }
}