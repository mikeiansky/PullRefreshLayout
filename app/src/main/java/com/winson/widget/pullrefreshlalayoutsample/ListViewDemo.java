package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemo extends AppCompatActivity {

    PullRefreshLayout pullRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_sample);

        pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        PullRefreshHeadLayout headView2 = (PullRefreshHeadLayout) LayoutInflater.from(this).inflate(R.layout.pull_refresh_head_view, pullRefreshLayout, false);
        pullRefreshLayout.addHeadWatcher(headView2);
        PullRefreshListView contentView = (PullRefreshListView) LayoutInflater.from(this).inflate(R.layout.pull_refresh_list_view, pullRefreshLayout, false);
        pullRefreshLayout.addContentWatcher(contentView);


        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add(" position : " + i);
        }

        contentView.setAdapter(new CommonAdapter<String>(
                this, R.layout.text_list_item, datas
        ) {
            @Override
            public void convert(ViewHolder viewHolder, String obj, int position) {
                ((TextView) viewHolder.findViewById(R.id.title)).setText(obj);
            }
        });

        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.refreshComplete(3000);
            }
        });

    }

}
