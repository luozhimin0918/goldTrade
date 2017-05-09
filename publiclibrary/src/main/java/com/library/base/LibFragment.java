package com.library.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.library.R;
import com.library.util.StatusBarCompat;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by DaiYao on 2016/5/28 0028.
 */
public abstract class LibFragment extends Fragment {

    protected final String TAG = this.getClass().getName();

    private LinearLayout replaceLayout;
    private LayoutInflater inflater;
    private Unbinder unbinder;

    /**
     * 使用OnDataBinding标注
     */
    protected ViewDataBinding viewDataBinding;

    protected abstract void onInitialize(Bundle savedInstanceState);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        onInitialize(savedInstanceState);
        return replaceLayout;
    }

    protected void setContentView(int layoutResID) {
        this.setContentView(layoutResID, LibActivity.StatusBarColor.NO_COLOR);
    }

    /**
     * @param layoutResID
     * @param statusBarColor -1 则不填充标题栏
     */
    protected void setContentView(int layoutResID, LibActivity.StatusBarColor statusBarColor) {
        loadLayout(layoutResID, statusBarColor);
    }


    protected void setBindingView(@LayoutRes int layoutResID) {
        setBindingView(layoutResID, LibActivity.StatusBarColor.NO_COLOR);
    }

    protected void setBindingView(@LayoutRes int layoutResID, LibActivity.StatusBarColor statusBarColor) {
        loadLayout(layoutResID, statusBarColor);
        try {
            viewDataBinding = DataBindingUtil.bind(replaceLayout);
        } catch (Exception e) {
        }
    }

    /**
     * 加载布局
     *
     * @param layoutResID
     * @param statusBarColor
     */
    private void loadLayout(@LayoutRes int layoutResID, LibActivity.StatusBarColor statusBarColor) {
        View contentView = inflater.inflate(layoutResID, null);
        replaceLayout = (LinearLayout) inflater.inflate(R.layout.fragment_status, null);

        StatusBarCompat.compat(replaceLayout, statusBarColor.color);

        contentView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        replaceLayout.addView(contentView);
        unbinder = ButterKnife.bind(this, replaceLayout);
    }

    public View getContentView() {
        return replaceLayout;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
