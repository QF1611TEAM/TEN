package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.musketeer.ten.R;
import com.squareup.picasso.Picasso;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.HashMap;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by Kevin on 2016/9/20.
 */
public class MineFragment extends BaseFragment implements Handler.Callback,View.OnClickListener, PlatformActionListener {
    public static final String TAG = MineFragment.class.getSimpleName();
    private View mLogin;
    @BindView(R.id.head_img)
    ImageView mHeadImage;
    @BindView(R.id.usr_name)
    TextView mUsrName;
    private Handler mHandler = new Handler(this);

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.minefragment, container, false);
        ButterKnife.bind(this,layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLogin = layout.findViewById(R.id.login);
        mLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //点击登入

        ShareSDK.initSDK(getActivity());
        Platform platform = ShareSDK.getPlatform(getActivity(), QQ.NAME);
        platform.setPlatformActionListener(this);

        platform.authorize();
        platform.showUser(null);
    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

        String data []={(String) hashMap.get("figureurl_qq_2"), (String) hashMap.get("nickname")};
        Message obtain = Message.obtain();
        obtain.what = 100;
        obtain.obj = data;
        mHandler.sendMessage(obtain);
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {
        Log.e(TAG, "onError: ");
    }

    @Override
    public void onCancel(Platform platform, int i) {
        Log.e(TAG, "onCancel: ");
    }

//    将获取的用户信息更新到UI
    @Override
    public boolean handleMessage(Message msg) {
        if (msg.what == 100) {
            String data [] = (String[]) msg.obj;
//            Picasso.with(getContext()).load(data[0]).rotate(25).into(mHeadImage);
            ImageOptions options = new ImageOptions.Builder()
                    .setRadius(45)
                    .build();
            x.image().bind(mHeadImage,data[0], options);
            mUsrName.setText(data[1]);
        }
        return false;
    }
}
