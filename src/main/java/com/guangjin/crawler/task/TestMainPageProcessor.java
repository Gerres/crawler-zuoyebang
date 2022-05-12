package com.guangjin.crawler.task;

import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;

import java.util.HashMap;
import java.util.List;

/**
 * @author jbb~
 * @version 1.0
 */
@Component
public class TestMainPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    public static final List<String> list = null;

    @Override
    public void process(Page page) {

        // FINISHED: 1、自动判断有没有下一页，爬取所有页数据
        // TODO: 2、答案爬取后对其进行数据清洗与整理，根据问题分配对应的答案
        // TODO: 3、试卷的去重(可以参考使用布隆过滤器)

        // 判断有没有下一页(是否添加到队列中)
        if (hasNext(page)) {

            // 获取url来拼接
            String href = page.getHtml().css(".pg strong + a", "href").toString();
            if (href != null) {
                String url = "http://5utk.ks5u.com/" + href;
                page.addTargetRequest(url);
                System.out.println("url：" + url);
            }

            // 获取pageNum来拼接
//            String pageNum = page.getHtml().css(".pg strong + a", "text").toString();
//            System.out.println("--------pageNum：" + pageNum);
//            Common.concatHighSchool_Real_Chinese_baseURL(pageNum);
//            page.addTargetRequest(Common.HighSchool_Real_Chinese_URL);
//            System.out.println("HighSchool_Real_Chinese_URL：" + Common.HighSchool_Real_Chinese_URL);
        }

        if (page.getUrl().toString().contains("main.aspx")) {
            listCrawl(page);
        } else if (page.getUrl().toString().contains("paperList.aspx")) {
            testCrawl(page);
        } else {
            System.out.println("----------爬取失败(未知错误)----------");
        }

    }

    @Override
    public Site getSite() {
        return site;
    }

    // 列表页的爬取
    public void listCrawl(Page page) {
        List<String> list = page.getHtml().$(".qt-info-title").$("a", "href").all();
        // for循环给地址加上url
        for (int i = 0; i < list.size(); i++) {
            String URL = "http://5utk.ks5u.com/" + list.get(i);
            list.set(i, URL);
        }
        // 将待爬取的详情页url添加到队列
        page.addTargetRequests(list);
    }

    // 考卷真题页问题和答案的爬取
    public void testCrawl(Page page) {
        // 获取本套试卷的标题
        page.putField("title", page.getHtml().css(".h2_detail .txt", "text"));
        // 获取本套书卷的问题内容
        page.putField("content", page.getHtml().css(".ksBody #examItemArea .bodyer_1 .bodyer_3 p span", "text").all());
        // 获取本套试卷的试题id和答案
        page.putField("answer", page.getHtml().css(".bodyer_5>span, .bodyer_5 div p span", "text").all());
    }

    // 判断有没有下一页
    public boolean hasNext(Page page) {
        String next = page.getHtml().css(".pg .nxt").all().toString();
        return next != null;
    }
}
