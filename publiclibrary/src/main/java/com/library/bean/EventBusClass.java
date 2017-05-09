package com.library.bean;

/**
 * @author Mr'Dai
 * @date 2016/5/20 14:28
 * @Title: MobileLibrary
 * @Package com.library.bean
 * @Description:
 */
public class EventBusClass {

    public static final int EVENT_FLASH_FILTRATE = 1;//快讯筛选
    public static final int EVENT_LOGIN = 2;//登录
    public static final int EVENT_LOGOUT = 3;//退出登录

    public EventBusClass(int fromCode, Object intentObj) {
        this.fromCode = fromCode;
        this.intentObj = intentObj;
    }

    /**
     * 来自哪里Code值
     */
    public int fromCode;

    /**
     * 传输的对象
     */
    public Object intentObj;
}
