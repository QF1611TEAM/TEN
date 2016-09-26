package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.musketeer.ten.Beans.CriticBean;
import com.musketeer.ten.Beans.DiagramBean;
import com.musketeer.ten.R;
import com.musketeer.ten.adapters.DiagramAdapter;
import com.musketeer.ten.constants.HttpConstant;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by Kevin on 2016/9/20.
 */
public class DiagramFragment extends BaseFragment implements View.OnClickListener {
    public static final String TAG = DiagramFragment.class.getSimpleName();
    private ViewPager mViewPager;
    private ImageView mFloatBall;
    private DiagramShowFragment diagramShowFragment;
    List<DiagramShowFragment> data = null;
    DiagramAdapter adapter = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.diagramfragment, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        setUpView();
    }
    private void setUpView() {

        RequestParams requestParams = new RequestParams(HttpConstant.DIAGRAM_URL);
        x.http().get(requestParams, new Callback.CommonCallback<DiagramBean>() {


            private List<DiagramBean.ResultBean> mResult;

            @Override
            public void onSuccess(DiagramBean result) {
                mResult = result.getResult();
                //遍历生成显示内容的Fragment
                for (int i = 0; i < mResult.size(); i++) {
                    diagramShowFragment = new DiagramShowFragment();
                    //将id传入显示内容的Fragment
                    Bundle bundle = new Bundle();
                    bundle.putInt("id",mResult.get(i).getId());
                    diagramShowFragment.setArguments(bundle);
                    data.add(diagramShowFragment);
                }
                adapter.addData(data);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
//        Log.e(TAG, "setUpView: " + ids );
    }

    private void initView() {
        //分享按钮
//        mFloatBall = ((ImageView) layout.findViewById(R.id.float_ball));
//        mFloatBall.setOnClickListener(this);
        mViewPager = ((ViewPager) layout.findViewById(R.id.diagram_view_pager));
        createFragment();

    }

    private void createFragment() {
        data = new ArrayList<>();
        adapter = new DiagramAdapter(getChildFragmentManager(), null);
        mViewPager.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        showShare();
    }

    //    -------------------分享------------------
    private void showShare() {
        ShareSDK.initSDK(getActivity());
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

// 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("分享");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://f1.sharesdk.cn/imgs/2014/02/26/owWpLZo_638x960.jpg");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

// 启动分享GUI
        oks.show(getActivity());
    }
}
