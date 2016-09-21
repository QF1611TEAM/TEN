package com.musketeer.ten;

import android.app.Application;

import org.xutils.x;

/**
 * Created by Kevin on 2016/9/21.
 */
public class TenApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }


}
