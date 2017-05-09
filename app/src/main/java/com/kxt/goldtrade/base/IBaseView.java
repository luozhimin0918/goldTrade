package com.kxt.goldtrade.base;

import android.content.Context;

import com.android.volley.RequestQueue;

/**
 * Created by Mr'Dai on 2017/2/27.
 */

public interface IBaseView {
    /**
     * 得到上下文环境
     *
     * @return
     */
    Context getContext();

    /**
     * 显示屏幕Dialog
     */
    void showWaitDialog(String tipInfo);


    /**
     * 取消等待的Dialog
     */
    void dismissWaitDialog();

    /**
     * 得到Activity 对应的Queue
     *
     * @return
     */
    RequestQueue getQueue();

}
