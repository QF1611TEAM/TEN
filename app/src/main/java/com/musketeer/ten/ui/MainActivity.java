package com.musketeer.ten.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.musketeer.ten.R;
import com.musketeer.ten.ui.fragments.CriticFragment;
import com.musketeer.ten.ui.fragments.DiagramFragment;
import com.musketeer.ten.ui.fragments.MineFragment;
import com.musketeer.ten.ui.fragments.NovelFragment;
import com.nineoldandroids.animation.ObjectAnimator;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    @BindView(R.id.fragment_container)
    FrameLayout mFragmentContainer;
    @BindView(R.id.btn_critic)
    RadioButton mBtnCritic;
    @BindView(R.id.btn_novel)
    RadioButton mBtnNovel;
    @BindView(R.id.btn_diagram)
    RadioButton mBtnDiagram;
    @BindView(R.id.btn_mine)
    RadioButton mBtnMine;
    @BindView(R.id.main_btn_container)
    RadioGroup mMainBtnContainer;
    @BindView(R.id.main_image_favorite)
    ImageView mFavoriteBtn;

    //记录开始的Y位置
    private float myStartY;

    //记录最后的Y位置
    private float myLastY;
    //
    private Fragment mShowFragment;
    // 极限值
    private float threshold = 300;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();

        initListener();
    }

    private void initView() {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();

        mShowFragment = new CriticFragment();

        transaction.add(R.id.fragment_container, mShowFragment, CriticFragment.TAG);

        transaction.commit();



    }

    /**
     * 初始化监听
     */
    private void initListener() {
        mMainBtnContainer.setOnCheckedChangeListener(this);

        mFavoriteBtn.setOnClickListener(this);
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        switch (checkedId) {

            case R.id.btn_critic:
                switchPages(CriticFragment.TAG, CriticFragment.class);
                break;

            case R.id.btn_novel:

                switchPages(NovelFragment.TAG, NovelFragment.class);

                break;

            case R.id.btn_diagram:

                switchPages(DiagramFragment.TAG, DiagramFragment.class);

                break;

            case R.id.btn_mine:

                switchPages(MineFragment.TAG, MineFragment.class);

                break;
        }
    }

    /**
     * 切换页面的封装
     *
     * @param tag           添加碎片的标记
     * @param fragmentClass 添加碎片的class
     */
    private void switchPages(String tag, Class<? extends Fragment> fragmentClass) {

        /**
         * 将当前显示的碎片进行隐藏，之后将要显示的页面显示出来
         */
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //隐藏显示页面
        transaction.hide(mShowFragment);

        //根据TAG去FragmentManager中查找碎片
        mShowFragment = fragmentManager.findFragmentByTag(tag);

        //如果找到了直接进行显示
        if (mShowFragment != null) {
            transaction.show(mShowFragment);
        } else {
            //如果没有找到，添加到容器中并设置一个标志
            try {

                mShowFragment = fragmentClass.getConstructor().newInstance();

            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            transaction.add(R.id.fragment_container, mShowFragment, tag);

        }

        transaction.commit();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {

        float y = event.getY();

        Log.e(TAG, "onTouchEvent: y" + y);

        switch (event.getAction()) {

            case MotionEvent.ACTION_DOWN:

                myStartY = y;

                myLastY = y;

                Log.e(TAG, "onTouch: y:" + y);

                break;

            case MotionEvent.ACTION_MOVE:

                Log.e(TAG, "onTouch: 触摸事件");

                float yDelta = y - myLastY;

                if (Math.abs(yDelta) > threshold && y < myLastY) {
                    //设置控制条隐藏
                    ObjectAnimator.ofFloat(mMainBtnContainer, "alpha", 0).setDuration(600).start();
                    ObjectAnimator.ofFloat(mFavoriteBtn, "alpha", 0).setDuration(600).start();
                } else if (Math.abs(yDelta) > threshold && y > myLastY) {
                    //控制控制条显示
                    ObjectAnimator.ofFloat(mMainBtnContainer, "alpha", 1).setDuration(600).start();
                    ObjectAnimator.ofFloat(mFavoriteBtn, "alpha", 1).setDuration(600).start();
                }
                break;
        }

        return super.dispatchTouchEvent(event);
    }

    //--------------------mFavoriteBtn点击监听---------------------
    @Override
    public void onClick(View v) {

        showPopupWindow(v);

    }

    /**
     * popupwindow 弹出框
     * @param view
     */
    private void showPopupWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(
                R.layout.popup_process, null);
        // 设置按钮的点击事件
        Button button = (Button) contentView.findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "button is pressed",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final PopupWindow popupWindow = new PopupWindow(contentView,
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, true);

        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Log.i("mengdd", "onTouch : ");

                return false;
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
            }
        });

        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
//        popupWindow.setBackgroundDrawable(getResources().getDrawable(
//                R.drawable.selectmenu_bg_downward));

        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);

    }
}
