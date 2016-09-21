package com.musketeer.ten.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.musketeer.ten.R;
import com.musketeer.ten.ui.fragments.BaseFragment;
import com.musketeer.ten.ui.fragments.CriticFragment;
import com.musketeer.ten.ui.fragments.DiagramFragment;
import com.musketeer.ten.ui.fragments.MineFragment;
import com.musketeer.ten.ui.fragments.NovelFragment;

import java.lang.reflect.InvocationTargetException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

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
    //
    private Fragment mShowFragment;

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


}
