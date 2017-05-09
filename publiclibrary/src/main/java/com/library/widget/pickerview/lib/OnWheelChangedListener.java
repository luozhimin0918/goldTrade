package com.library.widget.pickerview.lib;

/**
 * 项目名:Android-PickerView-master
 * 类描述:
 * 创建人:苟蒙蒙
 * 创建日期:2017/4/5.
 */
public interface OnWheelChangedListener {
    /**
     * Callback method to be invoked when current item changed
     *
     * @param wheel    the wheel view whose state has changed
     * @param oldValue the old value of current item
     * @param newValue the new value of current item
     */
    void onChanged(WheelView wheel, int oldValue, int newValue);
}
