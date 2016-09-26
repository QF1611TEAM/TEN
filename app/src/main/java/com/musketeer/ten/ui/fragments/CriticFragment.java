package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.musketeer.ten.Beans.CriticBean;
import com.musketeer.ten.Beans.NovelBeanList;
import com.musketeer.ten.R;
import com.musketeer.ten.adapters.CriticAdapter;
import com.musketeer.ten.constants.HttpConstant;
import com.musketeer.ten.utils.NetWorkUtils;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Kevin on 2016/9/20.
 */
public class CriticFragment extends BaseFragment implements Handler.Callback, ViewPager.OnPageChangeListener {
    public static final String TAG = CriticFragment.class.getSimpleName();
    @BindView(R.id.critle_data_shi)
    ImageView mCritleDataShi;
    @BindView(R.id.critle_data_ge)
    ImageView mCritleDataGe;
    @BindView(R.id.critle_week)
    ImageView mCritleWeek;
    @BindView(R.id.critle_month)
    ImageView mCritleMonth;

    private List<CriticBean.ResultBean> Results;

    private int[] weeks = {R.mipmap.week_7, R.mipmap.week_1, R.mipmap.week_2, R.mipmap.week_3,
            R.mipmap.week_4, R.mipmap.week_5, R.mipmap.week_6,};
    private int[] months = {R.mipmap.month_1, R.mipmap.month_2, R.mipmap.month_3, R.mipmap.month_4,
            R.mipmap.month_5, R.mipmap.month_6, R.mipmap.month_7, R.mipmap.month_8, R.mipmap.month_9,
            R.mipmap.month_10, R.mipmap.month_11, R.mipmap.month_12};
    private int[] datas = {R.mipmap.date_0, R.mipmap.date_1, R.mipmap.date_2, R.mipmap.date_3,
            R.mipmap.date_4, R.mipmap.date_5, R.mipmap.date_6, R.mipmap.date_7, R.mipmap.date_8,
            R.mipmap.date_9};

    @BindView(R.id.critic_viewpager)
    ViewPager mViewpager;

    @BindView(R.id.critic_loading_image)
    ImageView mLoadingImage;
    //
    private CriticAdapter mAdapter;
    //
    private Handler mHandler = new Handler(this);
    //
    DbManager.DaoConfig mConfig = new DbManager.DaoConfig()
            .setDbName("CirticDataBase");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.criticfragment, container, false);

        ButterKnife.bind(this, layout);

        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initView();

        setView();
    }

    /**
     * 初始化控件
     */
    private void initView() {

        mViewpager.setOnPageChangeListener(this);

        mAdapter = new CriticAdapter(getFragmentManager(), null);

        mViewpager.setAdapter(mAdapter);
    }

    /**
     * 设置数据
     */
    private void setView() {

        if (NetWorkUtils.isConnected(getActivity())) {
            //有网络，从网络中获取数据，开始loading动画
            getDataFromHttp();

            mLoadingImage.setVisibility(View.VISIBLE);
        } else {
            //没有网络，友情提示，获取数据库中的数据
            Toast.makeText(getActivity(), "当前网络状态不稳定，无法刷新", Toast.LENGTH_SHORT).show();

            getDataFromDataBase();
        }

    }

    /**
     * 获取数据库中的数据
     */
    private void getDataFromDataBase() {

        DbManager dbManager = x.getDb(mConfig);

        try {

            List<CriticBean> criticBeanList = dbManager.selector(CriticBean.class).findAll();

            if (criticBeanList != null) {

                Log.e(TAG, "getDataFromDataBase: " + criticBeanList.toString());

                List<CriticChildFragment> childFragment = getChildFragment(criticBeanList.get(0).getResult());

                mAdapter.upDataRes(childFragment);

            } else {
                // TODO 弹出提示 点击刷新
                Toast.makeText(getActivity(), "本地获取数据失败", Toast.LENGTH_SHORT).show();

            }

        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取网络数据并存储到数据库
     */
    private void getDataFromHttp() {

        RequestParams requestParams = new RequestParams(HttpConstant.CIRTIC_URL);

        requestParams.setCacheMaxAge(3 * 1000);

        x.http().get(requestParams, new Callback.CommonCallback<CriticBean>() {

            @Override
            public void onSuccess(CriticBean result) {

                Log.e(TAG, "网络请求成功onSuccess: " + result);

                if (result != null) {

                    List<CriticChildFragment> data = getChildFragment(result.getResult());

                    mAdapter.upDataRes(data);

                    Results = result.getResult();

                    long publishtime = Results.get(0).getPublishtime()/10000;
                    String date = getLongPointDate(publishtime);
                    String[] split = date.split("-");
                    upDataUI(split);

                    //数据库存储
                    DbManager dbManager = x.getDb(mConfig);


                    for (int i = 0; i < Results.size(); i++) {

                        try {

                            dbManager.saveOrUpdate(Results.get(i));

                        } catch (DbException e) {

                            e.printStackTrace();
                        }

                    }
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e(TAG, "onError: " + ex.getMessage());

                Toast.makeText(getActivity(), "获取网络数据失败", Toast.LENGTH_SHORT).show();

                // TODO 点击刷新

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

                Log.e(TAG, "onFinished: ");
                //加载完成，设置加载动画隐藏
                mLoadingImage.setVisibility(View.GONE);
            }
        });
    }

    public static String getLongPointDate(long lo){
        Date date = new Date(lo);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        return sd.format(date);
    }

    /**
     * 添加子Fragment
     */
    private List<CriticChildFragment> getChildFragment(List<CriticBean.ResultBean> result) {

        List<CriticChildFragment> data = new ArrayList<>();

        for (int i = 0; i < result.size(); i++) {

            CriticChildFragment fragment = new CriticChildFragment();

            Bundle bundle = new Bundle();
            int id = result.get(i).getId();
            String image = result.get(i).getImage();
            bundle.putInt("id", id);
            bundle.putString("image", image);
            fragment.setArguments(bundle);

            data.add(fragment);
        }

        return data;
    }


//-------------------handler监听-------------------------

    @Override
    public boolean handleMessage(Message msg) {

        return false;
    }

    private void upDataUI(String[] split) {
        int year = Integer.parseInt(split[0]) - 1970;
        int yue = Integer.parseInt(split[1]);
        int ri = Integer.parseInt(split[2]);
        for (int i = 1; i < 13; i++) {
            if (i == yue) {
                mCritleMonth .setImageResource(months[i - 1]);
                break;
            }
        }
        int ri_ge = ri % 10;
        int ri_shi = ri / 10;
        for (int i = 0; i < 10; i++) {
            if (i == ri_ge) {
                mCritleDataGe.setImageResource(datas[i]);
            }
            if (i == ri_shi) {
                mCritleDataShi.setImageResource(datas[i]);
            }
        }
        Calendar instance = GregorianCalendar.getInstance();
        instance.set(year, yue, ri);
        long timeInMillis = instance.getTimeInMillis();
        int week = getWeek(timeInMillis);
        mCritleWeek.setImageResource(weeks[week - 1]);
    }

    private static int getWeek(long timeStamp) {
        int mydate = 0;
        String week = null;
        Calendar cd = Calendar.getInstance();
        cd.setTime(new Date(timeStamp));
        mydate = cd.get(Calendar.DAY_OF_WEEK);
        return mydate;
    }
    //---------------------------Viewpager切换监听---------------------------------------------
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        long publishtime = Results.get(position).getPublishtime()/10000;
        String date = getLongPointDate(publishtime);
        String[] split = date.split("-");
        upDataUI(split);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
