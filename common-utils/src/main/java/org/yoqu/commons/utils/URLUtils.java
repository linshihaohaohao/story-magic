package org.yoqu.commons.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author yoqu
 * @email yoqulin@qq.com
 * @date 2017/6/18
 * @time 11:47
 */
public class URLUtils {

    /**
     * 根据url获取网站域名
     * @param url
     * @return
     */
    public static String getUrlDomain(String url){
        Pattern p = Pattern.compile("(?<=http://|\\.)[^.]*?\\.(com|cn|net|org|biz|info|cc|tv)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(url);
        matcher.find();
        return matcher.group();
    }
}
