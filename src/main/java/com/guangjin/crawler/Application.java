package com.guangjin.crawler;

import com.guangjin.crawler.task.TestMainTask;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootApplication
@MapperScan(basePackages = "com.guangjin.crawler.mapper")
public class Application implements CommandLineRunner {

    @Resource
    private TestMainTask testMainTask;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        // 爬取知乎数据
        testMainTask.crawl();
    }
}