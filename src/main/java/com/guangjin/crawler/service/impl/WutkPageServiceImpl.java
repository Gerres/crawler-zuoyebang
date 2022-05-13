package com.guangjin.crawler.service.impl;

import com.guangjin.crawler.service.WutkPageService;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author C_LKF~
 * @version 1.0
 */
@Service
public class WutkPageServiceImpl implements WutkPageService {

    // 列表页的爬取
    @Override
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

    // 试卷页的爬取
    @Override
    public void testCrawl(Page page) {


        // 获取本套试卷的标题
        page.putField("title", page.getHtml().css(".h2_detail .txt", "text"));
        // 获取本套书卷的问题内容
        List<Selectable> questionNodes = page.getHtml().css(".ksBody #examItemArea .bodyer_1 .bodyer_3 p").nodes();
        // 清洗数据
        List questionList = rinseData(page, questionNodes);
        page.putField("content", questionList);

        // 获取本套试卷的试题id和答案
        List<Selectable> answerNodes = page.getHtml().css(".bodyer_5>span, .bodyer_5 div p").nodes();
        List answerList = rinseData(page, answerNodes);
        page.putField("answer", answerList);
    }

    private List rinseData(Page page, List nodes) {
        ArrayList<String> list = new ArrayList<>();
        // 对获取到的数据进行标签拆分，形成不同节点(因为webmagic可让我们操控的节点的力度较小，所以需要手动抽取数据)
        String[] splitNodes = nodes.toString().split("><");
        ArrayList<String> listNodes = new ArrayList<>();
        // 清洗数据-将拆分后的数组重新拼接上标签符号
        for (int i = 0; i < splitNodes.length; i++) {
            // 第一个标签缺">"，最后一个标签缺"<"；中间的标签开头缺"<"，结尾缺">"
            if (i == 0) {
                listNodes.add(splitNodes[i] + ">");
            }
            if (i == splitNodes.length - 1) {
                listNodes.add("<" + splitNodes[i]);
            }
            listNodes.add("<" + splitNodes[i] + ">");
        }

        // FINISHED: 2022/5/12 运行爬虫，观察控制台，想办法解决多余null和逗号问题
        for (String node : listNodes) {
            System.out.println("node：" + node);
            Html htmlNode = Html.create(node);
            if ((htmlNode.css("img", "src") != null) &&
                    (htmlNode.css("img", "src").toString() != null) &&
                    (!htmlNode.css("img", "src").toString().equals("null"))) {
                Selectable imgUrl = htmlNode.css("img", "src");
                System.out.println("imgUrl：" + imgUrl);
                list.add(imgUrl.toString());
            }
            if ((htmlNode.css("span", "text") != null) &&
                    (htmlNode.css("span", "text").toString() != null) &&
                    (!htmlNode.css("span", "text").toString().equals("null"))) {
                Selectable text = htmlNode.css("span", "text");
                System.out.println("text：" + text);
                list.add(text.toString());
            }
        }

        // TODO: 2022/5/13 对图片的url做处理，将图片保存到本地库，url替换为本地url

        return list;
    }
}
