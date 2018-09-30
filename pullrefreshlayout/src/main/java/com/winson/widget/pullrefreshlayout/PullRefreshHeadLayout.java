package com.winson.widget.pullrefreshlayout;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public class PullRefreshHeadLayout extends LinearLayout implements PullRefreshHeadWatcher {

    public static final String TAG = PullRefreshHeadWatcher.class.getSimpleName();

    public OnPullRefreshListener onPullRefreshListener;

    public void setOnPullRefreshListener(OnPullRefreshListener onPullRefreshListener) {
        this.onPullRefreshListener = onPullRefreshListener;
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
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onPullProgressUpdate(progress);
        }
    }

    @Override
    public void onRefresh() {
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefresh();
        }
    }

    @Override
    public void onRefreshComplete() {
        if (onPullRefreshListener != null) {
            onPullRefreshListener.onRefreshComplete();
        }
    }
}
