package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.winson.widget.pullrefreshlayout.PullRefreshGridView;
import com.winson.widget.pullrefreshlayout.PullRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class GridViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_sample);

        final PullRefreshLayout pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        PullRefreshHeadLayoutTest headView2 = (PullRefreshHeadLayoutTest) LayoutInflater.from(this).inflate(R.layout.pull_refresh_head_view, pullRefreshLayout, false);
        pullRefreshLayout.addHeadWatcher(headView2);
        PullRefreshGridView contentView1 = (PullRefreshGridView) LayoutInflater.from(this).inflate(R.layout.pull_refresh_grid_view, pullRefreshLayout, false);
        pullRefreshLayout.addContentWatcher(contentView1);

        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add(" position : " + i);
        }

        contentView1.setAdapter(new CommonAdapter<String>(
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
