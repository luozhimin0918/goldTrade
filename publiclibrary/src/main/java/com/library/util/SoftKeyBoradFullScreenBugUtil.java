package com.library.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

/**
 * 项目名:FirstGold 2.1.3
 * 类描述:解决全屏下软键盘遮盖bug
 * 在你的Activity的oncreate()方法里调用SoftKeyBoradFullScreenBugUtil.assistActivity(this);即可。注意：在setContentView(R.layout.xxx)之后调用。
 * 创建人:苟蒙蒙
 * 创建日期:2017/3/23.
 */

public class SoftKeyBoradFullScreenBugUtil {

    public static void assistActivity(Activity activity) {
        new SoftKeyBoradFullScreenBugUtil(activity);
    }

    private View mChildOfContent;
    private int usableHeightPrevious;
    private LinearLayout.LayoutParams frameLayoutParams;
    private int statuBarHeight;

    private SoftKeyBoradFullScreenBugUtil(Activity activity) {
        statuBarHeight = SystemUtil.getStatuBarHeight(activity);
        LinearLayout content = (LinearLayout) activity.findViewById(com.library.R.id.contents);
        mChildOfContent = content.getChildAt(1);
        mChildOfContent.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                possiblyResizeChildOfContent();
            }
        });
        frameLayoutParams = (LinearLayout.LayoutParams) mChildOfContent.getLayoutParams();
    }

    private void possiblyResizeChildOfContent() {
        int usableHeightNow = computeUsableHeight();
        if (usableHeightNow != usableHeightPrevious) {
            int usableHeightSansKeyboard = mChildOfContent.getRootView().getHeight();
            int heightDifference = usableHeightSansKeyboard - usableHeightNow;
            if (heightDifference > (usableHeightSansKeyboard / 4)) {
                // keyboard probably just became visible
                frameLayoutParams.height = usableHeightSansKeyboard - heightDifference;
            } else {
                // keyboard probably just became hidden
                frameLayoutParams.height = usableHeightSansKeyboard;
            }
            mChildOfContent.requestLayout();
            usableHeightPrevious = usableHeightNow;
        }
    }

    private int computeUsableHeight() {
        Rect r = new Rect();
        mChildOfContent.getWindowVisibleDisplayFrame(r);
        if (r.top == 0) {
            r.top = statuBarHeight;//状态栏目的高度
        }
        return (r.bottom - r.top);
    }

}
