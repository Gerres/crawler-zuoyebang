package com.guangjin.crawler.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Spider;

import javax.annotation.Resource;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author jbb~
 * @version 1.0
 */
@Component
public class TestMainTask {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMainPipeline.class);

    @Resource
    private TestMainPipeline testMainPipeline;

    @Resource
    private TestMainPageProcessor testMainPageProcessor;

    private ScheduledExecutorService timer = Executors.newSingleThreadScheduledExecutor();

    public void crawl() {
        timer.scheduleWithFixedDelay(() -> {
            Thread.currentThread().setName("wutkCrawlerThread");

            try {
                Spider.create(testMainPageProcessor)
                        .addUrl(
                                // 语文
//                                URLCommon.HighSchool_Real_Chinese_URL
                                // 数学
//                                URLCommon.HighSchool_Real_Math_URL
                                // 历史
//                                URLCommon.HighSchool_Real_History_URL
                                // 生物
//                                URLCommon.HighSchool_Real_Biology_URL
                                // 英语
                                URLCommon.HighSchool_Real_English_URL
                                // 地理
//                                URLCommon.HighSchool_Real_Geography_URL
                                // 政治
//                                URLCommon.HighSchool_Real_Politics_URL
                                // 化学
//                                URLCommon.HighSchool_Real_Chemistry_URL
                                // 物理
//                                URLCommon.HighSchool_Real_Physics_URL
                        )
                        // 抓取到的数据存数据库
                        .addPipeline(testMainPipeline)
                        // 开启2个线程抓取
                        .thread(2)
                        // 异步启动爬虫
                        .start();
            } catch (Exception ex) {
                LOGGER.error("定时抓取知乎数据线程执行异常", ex);
            }
        }, 0, 10, TimeUnit.MINUTES);
    }

}
