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

    // 考卷真题页的爬取
    public void testCrawl(Page page) {
        page.putField("title", page.getHtml().css(".h2_detail .txt", "text"));
        page.putField("content", page.getHtml().css(".ksBody #examItemArea .bodyer_1 .bodyer_3 p span", "text").all());
        String answerTitle = page.getHtml().css(".bodyer_5>span", "text").all().toString();
        String answerContent = page.getHtml().css(".bodyer_5 div p span", "text").all().toString();
        String answer = answerTitle + answerContent;
        page.putField("answer", answer);
    }
}
