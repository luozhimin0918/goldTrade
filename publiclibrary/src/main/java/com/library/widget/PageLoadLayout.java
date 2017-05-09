package com.library.widget;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.library.R;

/**
 * Created by DaiYao on 2016/5/21 0021.
 */
public class PageLoadLayout extends FrameLayout implements View.OnClickListener {
    public enum BgColor {
        WHITE(Color.WHITE), TRANSPARENT8(Color.parseColor("#88000000")), TRANSPARENT(Color.TRANSPARENT);

        int bgColor;

        BgColor(int bgColor) {
            this.bgColor = bgColor;
        }
    }

    private View llLoadView;

    public interface OnAfreshLoadListener {
        void OnAfreshLoad();
    }

    private OnAfreshLoadListener onAfreshLoadListener;

    private LayoutInflater mInflater;

    public PageLoadLayout(Context context) {
        this(context, null);
    }

    public PageLoadLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PageLoadLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mInflater = LayoutInflater.from(context);
    }

    public void setOnAfreshLoadListener(OnAfreshLoadListener onAfreshLoadListener) {
        this.onAfreshLoadListener = onAfreshLoadListener;
    }

    public void loadWait() {
        loadWait(BgColor.WHITE, null);
    }

    public void loadWait(BgColor bgColor, String desc) {
        removeLoading();
        llLoadView = mInflater.inflate(R.layout.volley_loading, this, false);
        llLoadView.setOnClickListener(null);

        ImageView ivProgress = (ImageView) llLoadView.findViewById(R.id.iv_progress);
        Glide.with(getContext()).load(R.mipmap.loading).asGif().into(ivProgress);

        TextView tvDesc = (TextView) llLoadView.findViewById(R.id.tv_desc);
        if (desc == null) {
            tvDesc.setVisibility(View.GONE);
        } else {
            tvDesc.setText(desc);
        }
        llLoadView.setBackgroundColor(bgColor.bgColor);

        updateView();
    }


    public void loadError() {
        removeLoading();
        llLoadView = mInflater.inflate(R.layout.volley_load_error, null);
        llLoadView.findViewById(R.id.id_volley_load_error).setOnClickListener(this);
        updateView();
    }

    private int nullImgId = 0;
    private String nullText = "";

    public void loadEmptyData() {
        removeLoading();
        llLoadView = mInflater.inflate(R.layout.volley_load_nodata, null);

        ImageView imageView = (ImageView) llLoadView.findViewById(R.id.id_volley_load_nodata_img);
        TextView textView = (TextView) llLoadView.findViewById(R.id.id_volley_load_nodata);

        if (nullImgId != 0) {
            imageView.setImageResource(nullImgId);
        }
        if (!TextUtils.isEmpty(nullText)) {
            textView.setText(nullText);
        }

        llLoadView.setOnClickListener(this);
        updateView();
    }

    public void loadOver() {
        removeLoading();
    }

    private void removeLoading() {
        if (llLoadView != null) {
            removeView(llLoadView);
        }
    }


    private void updateView() {
        addView(llLoadView);
    }


    public void addCustomView(int viewRes) {
        llLoadView = mInflater.inflate(viewRes, null);
        addCustomView(llLoadView);
    }

    public void addCustomView(View view) {
        removeLoading();
        llLoadView = view;
        updateView();
    }

    @Override
    public void onClick(View v) {
        if (onAfreshLoadListener != null) {
            onAfreshLoadListener.OnAfreshLoad();
        }
    }

    public int getNullImgId() {
        return nullImgId;
    }

    public void setNullImgId(int nullImgId) {
        this.nullImgId = nullImgId;
    }

    public String getNullText() {
        return nullText;
    }

    public void setNullText(String nullText) {
        this.nullText = nullText;
    }
}
