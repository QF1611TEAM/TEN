package com.musketeer.ten.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import com.musketeer.ten.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/20.
 */
public class SplashActivity extends BaseActivity implements Handler.Callback {

    public static final String TAG = SplashActivity.class.getSimpleName();
    private static final int START_JUMP = 100;
    private static final int START_ANIM = 200;
    private static final int DELAYED_TIME = 3 * 1000;
    @BindView(R.id.image_background)
    HorizontalScrollView mImageBackground;

    private int x;

    @BindView(R.id.image_splash)
    ImageView mImageSplash;

    private Handler mHandler = new Handler(this);


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        mHandler.sendEmptyMessage(START_ANIM);

        mHandler.sendEmptyMessageDelayed(START_JUMP, DELAYED_TIME);

    }

    //---------------------------------------------

    @Override
    public boolean handleMessage(Message msg) {

        switch (msg.what) {

            case START_JUMP:
                startActivity(new Intent(this, MainActivity.class));
                mHandler.removeMessages(START_ANIM);
                finish();
                break;

            case START_ANIM:
                mImageBackground.smoothScrollTo(x,0);
                x++;
                mHandler.sendEmptyMessageDelayed(START_ANIM, 50);
                break;
        }
        return false;
    }

}
