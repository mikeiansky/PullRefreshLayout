package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshScrollView;

public class ScrollViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_sample);

        final PullRefreshLayout pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        PullRefreshHeadLayout headView2 = (PullRefreshHeadLayout) LayoutInflater.from(this).inflate(R.layout.pull_refresh_head_view, pullRefreshLayout, false);
        pullRefreshLayout.addHeadWatcher(headView2);
        PullRefreshScrollView contentView1 = (PullRefreshScrollView) LayoutInflater.from(this).inflate(R.layout.scroll_view_demo, pullRefreshLayout, false);
        pullRefreshLayout.addContentWatcher(contentView1);

        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.refreshComplete(3000);
            }
        });
    }

}
