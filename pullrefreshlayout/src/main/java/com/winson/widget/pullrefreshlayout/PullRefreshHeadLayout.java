package com.winson.widget.pullrefreshlayout;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public class PullRefreshHeadLayout extends LinearLayout implements PullRefreshHeadWatcher {

    public static final String TAG = PullRefreshHeadWatcher.class.getSimpleName();

    public PullOnRefreshListener pullOnRefreshListener;

    public PullOnRefreshListener getPullOnRefreshListener() {
        return pullOnRefreshListener;
    }

    public void setPullOnRefreshListener(PullOnRefreshListener pullOnRefreshListener) {
        this.pullOnRefreshListener = pullOnRefreshListener;
    }

    public PullRefreshHeadLayout(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public PullRefreshHeadLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    public PullRefreshHeadLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PullRefreshHeadLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
    }

    @Override
    public View getStick() {
        return this;
    }

    @Override
    public void onPullProgressUpdate(int progress) {
        if (pullOnRefreshListener != null) {
            pullOnRefreshListener.onPullProgressUpdate(progress);
        }
    }

    @Override
    public void onRefresh() {
        if (pullOnRefreshListener != null) {
            pullOnRefreshListener.onRefresh();
        }
    }

    @Override
    public void onRefreshComplete() {
        if (pullOnRefreshListener != null) {
            pullOnRefreshListener.onRefreshComplete();
        }
    }
}
