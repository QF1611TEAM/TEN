package com.musketeer.ten.ui.fragments;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.musketeer.ten.Beans.CriticBean;
import com.musketeer.ten.Beans.CriticBeanBody;
import com.musketeer.ten.R;
import com.musketeer.ten.constants.HttpConstant;
import com.musketeer.ten.http.CriticParams;
import com.musketeer.ten.ui.MainActivity;
import com.musketeer.ten.utils.NetWorkUtils;
import com.squareup.picasso.Picasso;

import org.xutils.DbManager;
import org.xutils.common.Callback;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.lang.reflect.Field;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/21.
 */
@TargetApi(Build.VERSION_CODES.M)
public class CriticChildFragment extends BaseFragment {

    private static final String TAG = CriticFragment.class.getSimpleName();
    //
    @BindView(R.id.image_critic_item)
    ImageView mImageCriticItem;
    @BindView(R.id.title_critic)
    TextView mTitleCritic;
    @BindView(R.id.critic_author_times)
    TextView mCriticAuthorTimes;
    @BindView(R.id.critic_text1)
    TextView mCriticText1;
    @BindView(R.id.critic_image1)
    ImageView mCriticImage1;
    @BindView(R.id.critic_text2)
    TextView mCriticText2;
    @BindView(R.id.critic_realtitle)
    TextView mCriticRealtitle;
    @BindView(R.id.critic_image2)
    ImageView mCriticImage2;
    @BindView(R.id.critic_text3)
    TextView mCriticText3;
    @BindView(R.id.critic_text4)
    TextView mCriticText4;
    @BindView(R.id.critic_text5)
    TextView mCriticText5;
    @BindView(R.id.critic_image3)
    ImageView mCriticImage3;
    @BindView(R.id.critic_image4)
    ImageView mCriticImage4;
    @BindView(R.id.critic_author)
    TextView mCriticAuthor;
    @BindView(R.id.critic_authorbrief)
    TextView mCriticAuthorbrief;
    @BindView(R.id.critic_scroll)
    ScrollView mCriticScroll;
    //
    private int id;
    //
    DbManager.DaoConfig mCriticBeanBodyConfig = new DbManager.DaoConfig()
            .setDbName("CirticDataBaseBody");
    private String mImagePath;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.fragmnet_cirticchild, container, false);

        ButterKnife.bind(this, layout);

        Bundle bundle = getArguments();
        this.id = bundle.getInt("id", 100035);
        mImagePath = bundle.getString("image");
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

    }

    /**
     * 设置数据
     */
    private void setView() {

        if (NetWorkUtils.isConnected(getActivity())) {
            Log.e(TAG, "setView: 网络良好" );
            //有网络，从网络中获取数据，开始loading动画
            getDataFromHttp();

//            mLoadingImage.setVisibility(View.VISIBLE);

        } else {
            Log.e(TAG, "setView: 没有网络");
            //没有网络，友情提示，获取数据库中的数据
            Snackbar.make(getView(),"",Snackbar.LENGTH_SHORT).show();

            Toast.makeText(getActivity(), "当前网络状态不稳定，无法刷新", Toast.LENGTH_SHORT).show();

            getDataFromDataBase();
        }
    }

    /**
     * 数据库获取数据
     */
    private void getDataFromDataBase() {

        DbManager dbManager = x.getDb(mCriticBeanBodyConfig);
        try {

            CriticBeanBody criticBeanBody = dbManager.selector(CriticBeanBody.class).where("id", "=", this.id).findFirst();
            if (criticBeanBody != null) {

                refreshUI(criticBeanBody);

            } else {

                Toast.makeText(getActivity(), "本地获取数据失败", Toast.LENGTH_SHORT).show();

                // TODO 点击刷新
            }
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    /**
     * 网络获取数据
     */
    private void getDataFromHttp() {

        final DbManager dbManager = x.getDb(mCriticBeanBodyConfig);

        CriticParams params = new CriticParams();

        params.id = String.valueOf(id);

        x.http().get(params, new Callback.CommonCallback<CriticBeanBody>() {

            @Override
            public void onSuccess(CriticBeanBody result) {

                Log.e(TAG, "onSuccess: " + result);

                if (result != null) {

                    refreshUI(result);

                    try {

                        dbManager.saveOrUpdate(result);

                    } catch (DbException e) {
                        e.printStackTrace();
                    }

                } else {

                    Toast.makeText(getActivity(), "获取网络数据失败", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

                Log.e(TAG, "onError: " + ex.getMessage());

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 更新UI
     *
     * @param result
     */
    private void refreshUI(CriticBeanBody result) {
        mTitleCritic.setText(result.getTitle());
        mCriticAuthorTimes.setText("作者：" + result.getAuthor() + "\t\t|\t\t阅读量：" + result.getTimes());
        mCriticAuthor.setText(result.getAuthor());
        mCriticText1.setText(result.getText1());
        String text2 = result.getText2();
        String[] split = text2.split("\\r\\n\\r\\n");
        mCriticText2.setText("\r\n\r\n" + split[1]);
        mCriticText3.setText(result.getText3());
        mCriticText4.setText(result.getText4());
        mCriticText5.setText(result.getText5());
        mCriticRealtitle.setText(result.getRealtitle());
        mCriticAuthorbrief.setText(result.getAuthorbrief());
        Picasso.with(getActivity()).load(HttpConstant.IMAGE_HEAD_URL + mImagePath).placeholder(R.drawable.loading).into(mImageCriticItem);
        Picasso.with(getActivity()).load(HttpConstant.IMAGE_HEAD_URL + result.getImage1()).placeholder(R.drawable.loading).into(mCriticImage1);
        Picasso.with(getActivity()).load(HttpConstant.IMAGE_HEAD_URL + result.getImage2()).placeholder(R.drawable.loading).into(mCriticImage2);
        Picasso.with(getActivity()).load(HttpConstant.IMAGE_HEAD_URL + result.getImage3()).placeholder(R.drawable.loading).into(mCriticImage3);
        Picasso.with(getActivity()).load(HttpConstant.IMAGE_HEAD_URL + result.getImage4()).placeholder(R.drawable.loading).into(mCriticImage4);
    }

}
