package com.hunter.base.common.utils;

import com.hunter.base.common.vo.RemoveBlankTypeEnum;

import java.io.BufferedReader;
import java.io.Reader;
import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /**
     * 测试字符串是否为空
     *
     * @param str 测试字符串
     * @return boolean
     */
    public static boolean isEmptyString(final String str) {
        return str == null || str.trim().length() < 1;
    }

    /**
     * 测试字符串是否不为空.
     *
     * @param str 测试字符串
     * @return boolean
     */
    public static boolean isNotEmptyString(final String str) {
        return str != null && str.trim().length() > 0;
    }

    /**
     * 判断两字符串是否相等
     *
     * @param cs1
     * @param cs2
     * @return
     */
    public static boolean equals(final CharSequence cs1, final CharSequence cs2) {
        return Objects.equals(cs1, cs2);
    }

    /**
     * 校验邮箱，不包含@符号的.
     * @return true校验成功， false校验失败.
     */
    public static boolean checkEmail(String email) {
        if (isEmptyString(email)) {
            return false;
        }
        String regex;
        if (email.contains("@")) {
            regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        } else {
            regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*";

        }
        return Pattern.matches(regex, email);
    }


    /**
     * 校验邮箱，包含@符号的.
     * @return true校验成功， false校验失败.
     */
    public static boolean checkEmailContainAt(String email) {
        if (isEmptyString(email)) {
            return false;
        }
        String regex = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        return Pattern.matches(regex, email);
    }

    /**
     * 校验身份证.
     * @return true校验成功， false校验失败.
     */
    public static boolean checkIDCard(String IDNumber) {
        if (isEmptyString(IDNumber)) {
            return false;
        }
        String regex = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)"
                + "|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}[0-9Xx]$)";
        return Pattern.matches(regex, IDNumber);
    }


    /**
     * 校验手机号码.
     * @return true校验成功， false校验失败.
     */
    public static boolean checkPhone(String phone) {
        if (isEmptyString(phone)) {
            return false;
        }
        String regex = "^1(?:3\\d{3}|5[^4\\D]\\d{2}|8\\d{3}|7(?:[01356789]\\d{2}|4(?:0\\d|1[0-2]|9\\d))"
                + "|9[189]\\d{2}|6[567]\\d{2}|4(?:[14]0\\d{3}|[68]\\d{4}|[579]\\d{2}))\\d{6}$";
        return Pattern.matches(regex, phone);
    }

    /**
     * 加密手机号
     */
    public static String encryptPhone(String phone) {
        if (StringUtils.isNotEmptyString(phone) && phone.length() >= 11) {
            String prefix = phone.substring(0,3);
            String suffix = phone.substring(7,11);
            phone = prefix + "****" + suffix;
        }
        return phone;
    }

    /**
     * 字符串转大写
     */
    public static String upperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    /**
     * 移除字符串里的空格
     * @param str 需要移除空格的字符串
     * @param removeBlankTypeEnum 移除类型
     * @return 移除空格后的字符串
     */
    public static String removeBlank(String str, RemoveBlankTypeEnum removeBlankTypeEnum){
        String result = "";
        switch (removeBlankTypeEnum){
            case ALL:
                // 去除所有空格
                result = removeAllBlank(str);
                break;
            case EITHER_END:
                // 去除字符串两端空格
                result = removeEitherEndBlank(str);
                break;
            default:
                break;
        }
        return result;
    }

    /**
     * 去除所有空格
     * @param str 需要去除空格的字符串
     * @return 去除空格的字符串
     */
    private static String removeAllBlank(String str) {
        StringBuilder result = new StringBuilder();
        char[] val = str.toCharArray();
        for (char c : val) {
            if (c > ' ') {
                result.append(c);
            }
        }
        return result.toString();
    }

    /**
     * 去除字符串两端的空格
     * @param str 需要去除空格的字符串
     * @return 去除空格的字符串
     */
    private static String removeEitherEndBlank(String str) {
        String dest = str;
        if (isNotEmptyString(str)) {
            // 去除所有 ASCII 码小于 32 的特殊字符，例如：空格、单元分隔符、记录分隔符、回车键、换页键
            dest = dest.trim();
        }
        return dest;
    }

}
