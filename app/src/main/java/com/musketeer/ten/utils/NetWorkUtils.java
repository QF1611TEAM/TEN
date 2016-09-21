package com.musketeer.ten.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Kevin on 2016/9/21.
 */
public class NetWorkUtils {

    public static boolean isConnected(Context context) {

        // 获取连接的管理者
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {

            return true;
        }

        return false;
    }


}
