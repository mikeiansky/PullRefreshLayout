package com.winson.widget.pullrefreshlayout;

import android.view.View;

/**
 * <a href="https://github.com/WinsonZhou/PullRefreshLayout">the url of this project on the github</a>
 */
public interface PullRefreshHeadWatcher {

    /**
     * @param progress region is (0 - 100)
     */
    void onPullProgressUpdate(int progress);

    /**
     * It will be call when refresh start
     */
    void onRefresh();

    /**
     * It will be call when refresh completed
     */
    void onRefreshComplete();

    /**
     * @return the view will be add to pull refresh layout
     */
    View getStick();

}
