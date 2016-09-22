package com.musketeer.ten;

import android.app.Application;
import android.graphics.Bitmap;

import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;
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
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.defaultBitmapConfig(Bitmap.Config.RGB_565)
                //显示加载标签
        .indicatorsEnabled(true)
                //Log
        .loggingEnabled(true);
        Picasso.setSingletonInstance(builder.build());
    }


}
