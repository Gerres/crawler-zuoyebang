package com.guangjin.crawler.task;

/**
 * @author jbb~
 * @version 1.0
 */
public class URLCommon {

    // 高考真题(语文试卷)
    public static final String HighSchool_Real_Chinese_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=1&rn=10&q3=1&page=";
    public static String HighSchool_Real_Chinese_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=1&rn=10&q3=1&page=";
    // 高考真题(数学试卷)
    public static final String HighSchool_Real_Math_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=2&rn=10&q3=1&page=";
    public static String HighSchool_Real_Math_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=2&rn=10&q3=1&page=";
    // 高考真题(历史试卷)
    public static final String HighSchool_Real_History_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=3&rn=10&q3=1&page=";
    public static String HighSchool_Real_History_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=3&rn=10&q3=1&page=";
    // 高考真题(生物试卷)
    public static final String HighSchool_Real_Biology_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=4&rn=10&q3=1&page=";
    public static String HighSchool_Real_Biology_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=4&rn=10&q3=1&page=";
    // 高考真题(英语试卷)
    public static final String HighSchool_Real_English_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=5&rn=10&q3=1&page=";
    public static String HighSchool_Real_English_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=5&rn=10&q3=1&page=";
    // 高考真题(地理试卷)
    public static final String HighSchool_Real_Geography_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=6&rn=10&q3=1&page=";
    public static String HighSchool_Real_Geography_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=6&rn=10&q3=1&page=";
    // 高考真题(政治试卷)
    public static final String HighSchool_Real_Politics_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=7&rn=10&q3=1&page=";
    public static String HighSchool_Real_Politics_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=7&rn=10&q3=1&page=";
    // 高考真题(化学试卷)
    public static final String HighSchool_Real_Chemistry_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=8&rn=10&q3=1&page=";
    public static String HighSchool_Real_Chemistry_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=8&rn=10&q3=1&page=";
    // 高考真题(物理试卷)
    public static final String HighSchool_Real_Physics_baseURL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=9&rn=10&q3=1&page=";
    public static String HighSchool_Real_Physics_URL = "http://5utk.ks5u.com/main.aspx?mod=paper&ac=st&op=list&lm=&Years=&Grade=&bankid=9&rn=10&q3=1&page=";

    // 类加载时初始化URL
    static {
        // 初始化url为首页
        HighSchool_Real_Chinese_URL = HighSchool_Real_Chinese_baseURL + "1";
        HighSchool_Real_Math_URL = HighSchool_Real_Math_baseURL + "1";
        HighSchool_Real_History_URL = HighSchool_Real_History_baseURL + "1";
        HighSchool_Real_Biology_URL = HighSchool_Real_Biology_baseURL + "1";
        HighSchool_Real_English_URL = HighSchool_Real_English_baseURL + "1";
        HighSchool_Real_Geography_URL = HighSchool_Real_Geography_baseURL + "1";
        HighSchool_Real_Politics_URL = HighSchool_Real_Politics_baseURL + "1";
        HighSchool_Real_Chemistry_URL = HighSchool_Real_Chemistry_baseURL + "1";
        HighSchool_Real_Physics_URL = HighSchool_Real_Physics_baseURL + "1";
    }

    // 拼接高考真题(语文试卷)页码
    public static void concatHighSchool_Real_Chinese_baseURL(String pageNum) {
        URLCommon.HighSchool_Real_Chinese_URL = URLCommon.HighSchool_Real_Chinese_baseURL.concat(pageNum);
    }

    // 拼接高考真题(数学试卷)页码
    public static void concatHighSchool_Real_Math_baseURL(String pageNum) {
        URLCommon.HighSchool_Real_Math_URL = URLCommon.HighSchool_Real_Math_baseURL.concat(pageNum);
    }

}
