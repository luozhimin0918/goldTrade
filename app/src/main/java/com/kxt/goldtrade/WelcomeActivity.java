package com.kxt.goldtrade;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.kxt.goldtrade.base.BaseActivity;
import com.kxt.goldtrade.presenter.WelcomePresenter;
import com.library.base.LibActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 启动-欢迎界面
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.iv_welcome)
    public ImageView ivWelcome;
    @BindView(R.id.textTOT)
    public TextView textTOT;

    private WelcomePresenter welcomePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
        setContentView(R.layout.activity_welcome, LibActivity.StatusBarColor.NO_COLOR);
        welcomePresenter = new WelcomePresenter(this);

        welcomePresenter.initConfig();

//        Glide.with(this).load(R.raw.qidong).listener(new RequestListener<Integer, GlideDrawable>() {
//            @Override
//            public boolean onException(Exception e, Integer model, Target<GlideDrawable> target, boolean
//                    isFirstResource) {
//                return false;
//            }
//
//            @Override
//            public boolean onResourceReady(GlideDrawable resource, Integer model, Target<GlideDrawable> target,
//                                           boolean isFromMemoryCache, boolean isFirstResource) {
//                int duration = 0;
//                GifDrawable drawable = (GifDrawable) resource;
//                GifDecoder decoder = drawable.getDecoder();
//                for (int i = 0; i < drawable.getFrameCount(); i++) {
//                    duration += decoder.getDelay(i);
//                }
//                ivWelcome.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        WelcomeActivity.this.finish();
//                        startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
//                    }
//                }, duration + 1000);
//
//                return false;
//            }
//        }).into(new GlideDrawableImageViewTarget(ivWelcome, 1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
