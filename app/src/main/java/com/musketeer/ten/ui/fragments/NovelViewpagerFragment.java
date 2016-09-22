package com.musketeer.ten.ui.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.musketeer.ten.Beans.NovelBean;
import com.musketeer.ten.R;
import com.musketeer.ten.http.NovelRequestParams;

import org.xutils.common.Callback;
import org.xutils.x;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kevin on 2016/9/20.
 */
public class NovelViewpagerFragment extends BaseFragment {

    public static final String TAG = NovelViewpagerFragment.class.getSimpleName();
    @BindView(R.id.novel_title)
    TextView mNovelTitle;
    @BindView(R.id.novel_AuthorAndTimes)
    TextView mNovelAuthorAndTimes;
    @BindView(R.id.novel_summary)
    TextView mNovelSummary;
    @BindView(R.id.novel_text)
    TextView mNovelText;
    @BindView(R.id.novel_Author)
    TextView mNovelAuthor;
    @BindView(R.id.novel_Authorbrief)
    TextView mNovelAuthorbrief;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        layout = inflater.inflate(R.layout.novel_viewpager, container, false);
        ButterKnife.bind(this, layout);
        Bundle arguments = getArguments();
        int id = arguments.getInt("id",1);
        mNovelTitle.setText(id+"");
//        setUpView(id);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    private void setUpView(int id) {
        NovelRequestParams params = new NovelRequestParams();
        params.id=id;
        x.http().get(params, new Callback.CommonCallback<NovelBean>() {
            @Override
            public void onSuccess(NovelBean result) {
                NovelBean novelBean = result;
                setUpUI(novelBean);
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

    private void setUpUI(NovelBean novelBean) {
        mNovelTitle.setText(novelBean.getTitle());
        mNovelAuthorAndTimes.setText("作者:" +novelBean.getAuthor()+" | 阅读量:"+novelBean.getTimes());
        mNovelSummary.setText(novelBean.getSummary());
        mNovelText.setText(novelBean.getText());
        mNovelAuthor.setText(novelBean.getAuthor());
        mNovelAuthorbrief.setText(novelBean.getAuthorbrief());
    }

}
