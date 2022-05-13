package com.guangjin.crawler.service;

import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;

/**
 * @author C_LKF~
 * @version 1.0
 */
public interface WutkPageService {

    /**
     * 列表页的爬取
     * @param page
     */
    void listCrawl(Page page);

    /**
     * 考卷真题页问题和答案的爬取
     * @param page
     */
    void testCrawl(Page page);

}
