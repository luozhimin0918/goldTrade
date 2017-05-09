package com.library.base.http;

/**
 * 项目名:Kxt
 * 类描述:
 * 创建人:苟蒙蒙
 * 创建日期:2017/4/12.
 */

public class VarConstant {

    public static final String KEY = "kuaixun56pslui*!@~^jhk";


    /**
     * 网络请求参数
     */
    public static final String HTTP_CLIENT = "android";
    public static final String HTTP_VERSION = "version";
    public static final String HTTP_VERSION_VALUE = "1.0";
    public static final String HTTP_SYSTEM = "system";
    public static final String HTTP_SYSTEM_VALUE = "android";
    public static final String HTTP_CODE = "code";
    public static final String HTTP_ID = "id";
    public static final String HTTP_UID = "uid";
    public static final String HTTP_LASTID = "last_id";
    public static final String HTTP_CONTENT = "?content=";
    public static final String HTTP_CONTENT2 = "content";

    public static final String HTTP_USERNAME = "username";
    public static final String HTTP_PWD = "password";
    public static final String HTTP_EMAIL = "email";
    public static final String HTTP_SEX = "sex";
    public static final String HTTP_AVATAR = "avatar";
    public static final String HTTP_PROVINCE = "province";
    public static final String HTTP_CITY = "city";
    public static final String HTTP_ACCESS_TOKEN = "access_token";
    public static final String HTTP_TOKEN = "token";
    public static final String HTTP_TYPE = "type";  //1:QQ|2:微信|3:微博
    public static final String HTTP_OPENID = "openid";
    public static final String HTTP_UNIONID = "unionid";


    /**
     * 跳转
     */
    public static final String OCLASS_DATA = "data";//数据
    public static final String OCLASS_FLASH = "kuaixun";//快讯
    public static final String OCLASS_RL = "rili";//日历
    public static final String OCLASS_QUOTES = "quotes";//行情
    public static final String OCLASS_VIDEO = "video";//视听
    public static final String OCLASS_NEWS = "news";//要闻
    public static final String OCLASS_INDEX = "index";//首页
    public static final String OCLASS_DIANPING = "dianping";//点评
    public static final String OCLASS_SCHOOL = "school";//投资入门
    public static final String OCLASS_SEARCH = "search";//搜索
    public static final String OCLASS_DATING = "dating";//大厅
    public static final String OCLASS_ARTICLE = "article";//文章

    public static final String OACTION_LIST = "list";//列表
    public static final String OACTION_INDEX = "index";//首页
    public static final String OACTION_ETF = "etf";//ETF
    public static final String OACTION_DETAIL = "detail";//ETF
    public static final String OACTION_ARTICLE = "article";//文章
    public static final String OACTION_CFTC = "cftc";

    /**
     * umeng 配置信息
     * <p>
     * umeng分享版本 6.4.3
     * umeng推送版本 3.1.0a
     */
//    public static final String WX_APPID = "wx93dccc483df30be4";
//    public static final String WX_APPSECRET = "0828a1e0f1dd2791050113a9adb715a4";
    public static final String WX_APPID = "wxf6f6e8a2f5f3af5e";
    public static final String WX_APPSECRET = "3545273eea982cc0a424dcf6845e9200";

    //    public static final String SINA_APPKEY = "3864596803";
//    public static final String SINA_APPSECRET = "cff54ddbc22d70c65f4dd548611e524a";
//    public static final String SINA_CALLBACK = "http://sns.whalecloud.com";
    public static final String SINA_APPKEY = "2798094812";
    public static final String SINA_APPSECRET = "2f1ad2df099135ecc384bd4bf8d2a0c8";
    public static final String SINA_CALLBACK = "https://api.weibo.com/oauth2/default.html";

    public static final String QQ_APPID = "1101487761";
    public static final String QQ_APPKEY = "ddd0261bbb4375911faf75d5be3d2e34";

    /**
     * 列表最大数
     */
    public static final int LIST_MAX_SIZE = 30;

    /**
     * 要闻首页类型
     */
    public static final String NEWS_NAV = "newsNav";//导航
    public static final String NEWS_SLIDE = "slide";//轮播图
    public static final String NEWS_SHORTCUT = "shortcut";//按钮
    public static final String NEWS_AD = "ad";//广告
    public static final String NEWS_QUOTES = "quotes";//行情
    public static final String NEWS_LIST = "news";//要闻

    /**
     * 探索首页类型
     */
    public static final String EXPLORE_SLIDE = "slide";//轮播图
    public static final String EXPLORE_SHORTCUT = "shortcut";//按钮
    public static final String EXPLORE_TOPIC = "topic";//专题
    public static final String EXPLORE_ACTIVITY = "activity";//活动
    public static final String EXPLORE_BLOG_WRITER = "blog_writer";//作者
    public static final String EXPLORE_BLOG_ARTICLE = "blog_article";//文章

    public static final String SOCKET_DOMAIN = "http://appandroid.kxt.com";
    public static final String SOCKET_KEY = "android12345";

    public static final String SOCKET_CMD_HISTORY = "history";
    public static final String SOCKET_CMD_TIMELY = "timely";
    public static final String SOCKET_CMD_LOGIN = "login";

    /**
     * Socket返回信息类型
     */
    public static final String SOCKET_DO_DELETE = "delete";
    public static final String SOCKET_DO_MODIFY = "modify";

    /**
     * 快讯类型
     */
    public static final String SOCKET_FLASH_KUAIXUN = "KUAIXUN";
    public static final String SOCKET_FLASH_CJRL = "CJRL";
    public static final String SOCKET_FLASH_KXTNEWS = "KXTNEWS";

    /**
     * 快讯图片位置
     */
    public static final String SOCKET_FLASH_LEFT = "l";
    public static final String SOCKET_FLASH_RIGHT = "r";
    public static final String SOCKET_FLASH_TOP = "u";
    public static final String SOCKET_FLASH_BOTTOM = "d";

    /**
     * 重要性
     */
    public static final String IMPORTANCE_HIGH = "高";
    public static final String IMPORTANCE_LOW = "低";

    /**
     * 收藏类型
     */
    public static final String COLLECT_TYPE_VIDEO = "video";//视听
    public static final String COLLECT_TYPE_ARTICLE = "article";//文章

    /**
     * 点赞状态
     */
    public static final String GOOD_TYPE_NEWS = "news";//文章
    public static final String GOOD_TYPE_VIDEO = "video";//视听

    /**
     * 分享面板操作类型
     */
    public static final String FUNCTION_TYPE_COLLECT = "function_type_collect";//收藏
    public static final String FUNCTION_TYPE_GOOD = "function_type_good";//点赞

}
