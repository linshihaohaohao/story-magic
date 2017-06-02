package org.yoqu.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yoqu on 17-6-2.
 * 小说内容处理工具
 */
public class ContentStringUtils {


    /**
     * 替换div标签
     * @param str
     * @return
     */
    public static String filterDivTag(String str){
        return filterHtmlTag(str,"div");
    }

    /**
     *
     * 基本功能：过滤指定标签
     * <p>
     *
     * @param str
     * @param tag
     *            指定标签
     * @return String
     */
    public static String filterHtmlTag(String str, String tag) {
        String regxp = "<\\s*" + tag + "\\s+([^>]*)\\s*>";
        Pattern pattern = Pattern.compile(regxp);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        boolean result1 = matcher.find();
        while (result1) {
            matcher.appendReplacement(sb, "");
            result1 = matcher.find();
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}
