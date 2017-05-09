package com.kxt.goldtrade.base;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.bumptech.glide.Glide;
import com.kxt.goldtrade.R;
import com.library.base.LibActivity;
import com.library.util.SystemUtil;


/**
 * Created by Mr'Dai on 2017/2/22.
 */

public class BaseActivity extends LibActivity implements IBaseView {

    //跳转Activity 策略
    private int intentAnimation = 0;
    //动画退出
    private boolean isAnimationFinish;

    private PopupWindow waitPopup;

    @Override
    public RequestQueue getQueue() {
        return mQueue;
    }

    @Override
    public void showWaitDialog(final String tipInfo) {
        View waitView = LayoutInflater.from(this).inflate(R.layout.dialog_wait, null);
        ImageView ivProgress = (ImageView) waitView.findViewById(R.id.iv_progress);
        TextView tvDesc = (TextView) waitView.findViewById(R.id.tv_desc);

        if (!TextUtils.isEmpty(tipInfo)) {
            tvDesc.setText(tipInfo);
        } else {
            tvDesc.setVisibility(View.GONE);
        }

        Glide.with(this).load(R.mipmap.loading).asGif().into(ivProgress);

        waitPopup = new PopupWindow(waitView);

        waitPopup.setWidth(SystemUtil.dp2px(this, 80));
        waitPopup.setHeight(SystemUtil.dp2px(this, 80));

        waitPopup.setFocusable(true);
        waitPopup.setOutsideTouchable(true);

        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
        waitPopup.setBackgroundDrawable(dw);

        waitPopup.setAnimationStyle(R.style.PopupWindow_Style1);

        waitPopup.showAtLocation(waitView, Gravity.CENTER, 0, 0);
    }

    @Override
    public void dismissWaitDialog() {
        if (waitPopup != null && waitPopup.isShowing() && !isFinishing()) {
            waitPopup.dismiss();
        }
    }

    protected void onChangeTheme() {

    }


    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        addOverridePendingTransition(0);
    }


    public void finish(boolean isAnimationFinish) {
        this.isAnimationFinish = isAnimationFinish;
        finish();
    }

    @Override
    public void finish() {
        super.finish();
        if (isAnimationFinish) {
            intentAnimation = -1;
            addOverridePendingTransition(1);
        } else {
            addOverridePendingTransition(1);
        }
    }

    public void setIntentAnimation(int intentAnimation) {
        this.intentAnimation = intentAnimation;
    }

    /**
     * @param from 0 表示StartActivity动画,进入
     *             1 表示finish动画,退出
     */
    private void addOverridePendingTransition(int from) {
        switch (intentAnimation) {
            case -1://动画滑动退出的时候
                overridePendingTransition(0, from == 1 ? R.anim.activity_out1 : 0);
                break;
            case 0:

                break;
            case 1:
                overridePendingTransition(from == 0 ? R.anim.activity_in : 0, from == 1 ? R.anim.activity_out : 0);
                break;
            case 2:

                break;
        }
    }
}
