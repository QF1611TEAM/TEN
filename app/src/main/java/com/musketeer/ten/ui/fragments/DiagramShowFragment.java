package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.musketeer.ten.Beans.DiagramBean;
import com.musketeer.ten.Beans.DiagramBeanShow;
import com.musketeer.ten.R;
import com.musketeer.ten.http.DiagramParams;

import org.xutils.common.Callback;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hey on 2016/9/21.
 */
public class DiagramShowFragment extends Fragment {
    private static final String TAG = DiagramShowFragment.class.getSimpleName();
    private View layout;

    //通过ButterKnife导入控件
    @BindView(R.id.diagram_author)
    TextView mAuthor;
    @BindView(R.id.diagram_image)
    ImageView mImage;
    @BindView(R.id.diagram_source)
    TextView mSource;
    @BindView(R.id.diagram_summary)
    TextView mSummary;
    @BindView(R.id.diagram_title)
    TextView mTitle;
    private ImageOptions options;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.item_diagram, container, false);
        //ButterKnife导入（ui）注解
        ButterKnife.bind(this, layout);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        int id = arguments.getInt("id", 1);
        Log.e(TAG, "onCreateView: " + id);
        setUpView(id);
        options = new ImageOptions.Builder()
                .setFadeIn(true)
                .setLoadingDrawableId(R.mipmap.ic_launcher)
                .setFailureDrawableId(R.mipmap.ic_launcher)
                .build();
    }
    //网络加载数据（id为主Fragment传入的）
    private void setUpView(int id) {

        DiagramParams diagramParams = new DiagramParams();
        diagramParams.id = id;
        x.http().get(diagramParams, new Callback.CommonCallback<DiagramBeanShow>() {

            @Override
            public void onSuccess(DiagramBeanShow result) {
                //更新UI
                mTitle.setText(result.getTitle());
                x.image().bind(mImage, "http://api.shigeten.net/" + result.getImage1(), options);
                mAuthor.setText(result.getAuthorbrief());
                mSource.setText(result.getText2());
                mSummary.setText(result.getText1());
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
    }


}
