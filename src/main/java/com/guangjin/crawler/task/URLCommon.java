package com.guangjin.crawler.task;

/**
 * @author jbb~
 * @version 1.0
 */
public class URLCommon {

    // 高考真题(语文试卷)
    public static final String HighSchool_Real_Chinese_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=1&rn=10&q3=1&page=";
    public static String HighSchool_Real_Chinese_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=1&rn=10&q3=1&page=";

    // 类加载时初始化URL
    static {
        // 初始化url为首页
        HighSchool_Real_Chinese_URL = HighSchool_Real_Chinese_baseURL + "1";
    }

    // 拼接高考真题(语文试卷)页码
    public static void concatHighSchool_Real_Chinese_baseURL(String pageNum) {
        URLCommon.HighSchool_Real_Chinese_URL = URLCommon.HighSchool_Real_Chinese_baseURL.concat(pageNum);
    }

}
