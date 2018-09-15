package com.winson.widget.pullrefreshlayout;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ScrollView;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public class PullRefreshScrollView extends ScrollView implements PullRefreshContentWatcher {

    public static final String TAG = PullRefreshScrollView.class.getSimpleName();

    boolean onDrag;

    public PullRefreshScrollView(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public PullRefreshScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public PullRefreshScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PullRefreshScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
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
    public boolean onTop() {
        return getScrollY() == 0;
    }

    @Override
    public void setOnDrag(boolean onDrag) {
        this.onDrag = onDrag;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                if (!onDrag) {
                    super.onTouchEvent(ev);
                }
                break;
            default:
                super.onTouchEvent(ev);
                break;
        }
        return true;
    }

}
