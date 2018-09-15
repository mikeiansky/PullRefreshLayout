package com.winson.widget.pullrefreshlayout;

import android.view.View;

public interface PullRefreshContentWatcher {

    View getStick();

    boolean onTop();

    void setOnDrag(boolean onDrag);

}
