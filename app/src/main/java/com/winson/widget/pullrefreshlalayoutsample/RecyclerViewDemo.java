package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.winson.widget.pullrefreshlayout.PullRefreshHeadLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshLayout;
import com.winson.widget.pullrefreshlayout.PullRefreshListView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_sample);

        final PullRefreshLayout pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        PullRefreshHeadLayout headView2 = (PullRefreshHeadLayout) LayoutInflater.from(this).inflate(R.layout.pull_refresh_head_view, pullRefreshLayout, false);
        pullRefreshLayout.addHeadWatcher(headView2);

        MyRefreshRecyclerView contentView4 = (MyRefreshRecyclerView) LayoutInflater.from(this).inflate(R.layout.my_recycler_view, pullRefreshLayout, false);
        pullRefreshLayout.addContentWatcher(contentView4);

        contentView4.setLayoutManager(new LinearLayoutManager(this));
        contentView4.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_list_item, parent, false);
                MyViewHolder viewHolder = new MyViewHolder(root);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                ((TextView)holder.itemView.findViewById(R.id.title)).setText("position -- " + position);
            }

            @Override
            public int getItemCount() {
                return 30;
            }
        });

        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.refreshComplete(3000);
            }
        });
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
        }

    }

}
