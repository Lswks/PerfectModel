package com.example.bigmercu.perfectmodel.base;

import android.app.Application;

import com.example.bigmercu.perfectmodel.util.ContextHolder;
import com.facebook.stetho.Stetho;
import com.socks.library.KLog;
import com.squareup.leakcanary.LeakCanary;

/**
 * Created by bigmercu on 2016/9/4.
 * Email: bigmercu@gmail.com
 */
public class App extends Application {

    private static final boolean DEBUG = true;

    @Override
    public void onCreate() {
        super.onCreate();
        ContextHolder.initial(this);
        Stetho.initializeWithDefaults(this);
        LeakCanary.install(this);
        KLog.init(DEBUG, "Bigmercu");
    }
}