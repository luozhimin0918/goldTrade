package com.kxt.goldtrade.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.kxt.goldtrade.WelcomeActivity;
import com.kxt.goldtrade.annotion.BindObject;
import com.kxt.goldtrade.base.BasePresenter;
import com.kxt.goldtrade.base.IBaseView;
import com.library.base.http.HttpListener;
import com.library.base.http.VolleyRequest;
import com.library.util.SPUtils;

/**
 * 项目名:Kxt
 * 类描述:
 * 创建人:苟蒙蒙
 * 创建日期:2017/4/20.
 */

public class WelcomePresenter extends BasePresenter {

    @BindObject WelcomeActivity welcomeActivity;
    private RequestQueue queue;
    private VolleyRequest request;


    public WelcomePresenter(IBaseView iBaseView) {
        super(iBaseView);
    }

    public void initConfig() {
        queue = welcomeActivity.getQueue();
        request = new VolleyRequest(mContext, queue);

        welcomeActivity.textTOT.setText("tttttttttttttttt");
    }




}
