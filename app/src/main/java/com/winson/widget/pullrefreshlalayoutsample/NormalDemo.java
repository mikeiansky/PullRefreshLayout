package com.winson.widget.pullrefreshlalayoutsample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.winson.widget.pullrefreshlayout.PullRefreshLayout;

public class NormalDemo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_sample);

        final PullRefreshLayout pullRefreshLayout = findViewById(R.id.pull_refresh_layout);
        PullRefreshHeadLayoutTest headView2 = (PullRefreshHeadLayoutTest) LayoutInflater.from(this).inflate(R.layout.pull_refresh_head_view, pullRefreshLayout, false);
        pullRefreshLayout.addHeadWatcher(headView2);
        LinearLayout contentView1 = new LinearLayout(this);

        Button button = new Button(this);
        button.setText("Hello World!");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Hello World!", Toast.LENGTH_SHORT).show();
            }
        });
        contentView1.addView(button);

        contentView1.setBackgroundColor(getResources().getColor(R.color.md_green_300));
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        contentView1.setLayoutParams(lp);
        pullRefreshLayout.addContentView(contentView1);

        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pullRefreshLayout.refreshComplete(3000);
            }
        });

    }

}
