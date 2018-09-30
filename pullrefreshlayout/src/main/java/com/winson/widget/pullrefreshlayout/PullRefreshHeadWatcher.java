package com.winson.widget.pullrefreshlayout;

import android.view.View;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public interface PullRefreshHeadWatcher extends OnPullRefreshListener {

    /**
     * @return the view will be add to pull refresh layout
     */
    View getStick();

}
