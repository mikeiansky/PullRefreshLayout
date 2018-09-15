package com.winson.widget.pullrefreshlayout;

import android.view.View;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public interface PullRefreshContentWatcher {

    View getStick();

    boolean onTop();

    void setOnDrag(boolean onDrag);

}
