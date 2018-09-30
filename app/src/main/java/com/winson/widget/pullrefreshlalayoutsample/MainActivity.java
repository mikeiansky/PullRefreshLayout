package com.winson.widget.pullrefreshlalayoutsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_view);

        final List<ApiItem> demos = new ArrayList<>();
        ApiItem apiItem = new ApiItem("Normal View Demo", NormalDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("List View Demo", ListViewDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("Scroll View Demo", ScrollViewDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("Grid View Demo", GridViewDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("Recycler View Demo", RecyclerViewDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("Id Demo", IdDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("Layout Demo", LayoutDemo.class);
        demos.add(apiItem);

        apiItem = new ApiItem("JD Refresh Demo", JDRefreshActivity.class);
        demos.add(apiItem);

        listView.setAdapter(new CommonAdapter<ApiItem>(this, R.layout.list_item, demos) {
            @Override
            public void convert(ViewHolder viewHolder, ApiItem obj, int position) {
                ((TextView) viewHolder.findViewById(R.id.title)).setText(obj.mTitle);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ApiItem apiItem = demos.get(position);
                Intent intent = new Intent(MainActivity.this, apiItem.mClazz);
                startActivity(intent);
            }
        });

    }

}
