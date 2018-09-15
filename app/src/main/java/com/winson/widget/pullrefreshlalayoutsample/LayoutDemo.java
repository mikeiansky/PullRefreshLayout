package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import com.winson.widget.pullrefreshlayout.PullRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class LayoutDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_demo);

        final PullRefreshLayout pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.refreshComplete(3000);
            }
        });

        ListView listView = findViewById(R.id.list_view);
        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            datas.add(" position : " + i);
        }

        listView.setAdapter(new CommonAdapter<String>(
                this, R.layout.text_list_item, datas
        ) {
            @Override
            public void convert(ViewHolder viewHolder, String obj, int position) {
                ((TextView) viewHolder.findViewById(R.id.title)).setText(obj);
            }
        });



    }
}
