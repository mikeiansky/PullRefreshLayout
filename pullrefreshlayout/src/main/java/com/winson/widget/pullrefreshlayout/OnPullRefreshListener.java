package com.winson.widget.pullrefreshlayout;

/**
 * @Date 2018/9/30
 * @Author Winson
 */
public interface OnPullRefreshListener {

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

}
