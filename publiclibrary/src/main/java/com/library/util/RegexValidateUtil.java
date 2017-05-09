package com.library.util;


import android.text.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 使用正则表达式进行表单验证
 */

public class RegexValidateUtil {
    static boolean flag = false;
    static String regex = "";

    public static String errorInfo = "";

    private static boolean check(String str, String regex) {
        try {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        if (flag) {
            errorInfo = "";
        }
        return flag;
    }

    /**
     * 验证昵称
     *
     * @param name
     * @return
     */
    public static boolean checkName(String name) {
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(name.trim())) {
            errorInfo = "账号不能为空";
            return false;
        }
        return true;
    }

    /**
     * 验证密码
     *
     * @param pwd
     * @return
     */
    public static boolean checkPwd(String pwd) {
        if (TextUtils.isEmpty(pwd)) {
            errorInfo = "密码不能为空";
            return false;
        }
        if (pwd.length() < 6 || pwd.length() > 18) {
            errorInfo = "请输入6 - 18位密码";
            return false;
        }
        return true;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    public static boolean checkEmail(String email) {

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(email.trim())) {
            errorInfo = "邮箱不能为空";
            return false;
        }

        String regex = "^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        errorInfo = "邮箱不合法";
        return check(email, regex);
    }

    /**
     * 验证手机号码
     * 移动号码段:139、138、137、136、135、134、150、151、152、157、158、159、182、183、187、188、147
     * 联通号码段:130、131、132、136、185、186、145
     * 电信号码段:133、153、180、189
     *
     * @param cellphone
     * @return
     */
    public static boolean checkCellphone(String cellphone) {
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$";
        errorInfo = "手机号不合法";
        return check(cellphone, regex);
    }

    /**
     * 验证固话号码
     *
     * @param telephone
     * @return
     */
    public static boolean checkTelephone(String telephone) {
        String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
        errorInfo = "固定号码不合法";
        return check(telephone, regex);
    }

    /**
     * 验证传真号码
     *
     * @param fax
     * @return
     */
    public static boolean checkFax(String fax) {
        String regex = "^(0\\d{2}-\\d{8}(-\\d{1,4})?)|(0\\d{3}-\\d{7,8}(-\\d{1,4})?)$";
        errorInfo = "传真号不合法";
        return check(fax, regex);
    }

    /**
     * 验证QQ号码
     *
     * @param QQ
     * @return
     */
    public static boolean checkQQ(String QQ) {
        String regex = "^[1-9][0-9]{4,} $";
        errorInfo = "QQ号不合法";
        return check(QQ, regex);
    }

    public static boolean isEmpty(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str.trim()))
            return true;
        else
            return false;
    }
}
