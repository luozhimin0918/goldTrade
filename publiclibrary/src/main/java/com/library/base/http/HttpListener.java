package com.library.base.http;

import com.android.volley.VolleyError;

/**
 * @author Mr'Dai
 * @date 2016/5/17 17:25
 * @Title: MobileLibrary
 * @Package com.dxmobile.library
 * @Description:
 */
public abstract class HttpListener<T> {
    protected abstract void onResponse(T t);

    /**
     * 如果错误信息为空,则表示返回数据为空 或者 解析出现异常
     * @param error
     */
    protected void onErrorResponse(VolleyError error) {

    }
}
