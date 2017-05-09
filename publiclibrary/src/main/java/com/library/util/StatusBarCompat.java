package com.library.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class StatusBarCompat {
    /**
     * 不替换状态栏底色
     */
    private static final int INVALID_VAL = -1;


    public static void compat(Activity activity, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (statusColor == INVALID_VAL) {
                return;
            }

            ViewGroup contentView = (ViewGroup) activity.findViewById(android.R.id.content);

            View userContentView = contentView.getChildAt(0);

            ViewGroup parent = (ViewGroup) contentView.getParent();
            contentView.removeView(userContentView);
            parent.removeView(contentView);

            LinearLayout replaceLayout = new LinearLayout(activity);
            replaceLayout.setId(android.R.id.content);

            replaceLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));
            replaceLayout.setOrientation(LinearLayout.VERTICAL);


            View statusBarView = new View(activity);
            statusBarView.setTag("statusBar");

            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(activity));

            statusBarView.setBackgroundResource(statusColor);
            replaceLayout.addView(statusBarView, lp);

            replaceLayout.addView(userContentView);

            parent.addView(replaceLayout);
        }
    }

    public static void compat(LinearLayout replaceLayout, int statusColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (statusColor == INVALID_VAL) {
                return;
            }

            Context mContext = replaceLayout.getContext();

            View statusBarView = new View(mContext);
            statusBarView.setTag("fragment_statusBar");

            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(mContext));

            statusBarView.setBackgroundResource(statusColor);
            replaceLayout.addView(statusBarView, lp);
        }
    }


    private static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


}