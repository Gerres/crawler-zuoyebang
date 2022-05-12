package com.guangjin.crawler.task;

import com.guangjin.crawler.entity.Wutk;
import com.guangjin.crawler.entity.WutkAnswer;
import com.guangjin.crawler.mapper.WutkAnswerMapper;
import com.guangjin.crawler.mapper.WutkMapper;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;
import us.codecraft.webmagic.processor.PageProcessor;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * @author jbb~
 * @version 1.0
 */
@Component
public class TestMainPipeline implements Pipeline {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestMainPipeline.class);

    @Resource
    private WutkMapper wutkMapper;
    @Resource
    private WutkAnswerMapper wutkAnswerMapper;

    @Override
    public void process(ResultItems resultItems, Task task) {
        Object title = resultItems.get("title");
        System.out.println("title：" + title);
        Object content = resultItems.get("content");
        System.out.println("content：" + content);
        Object answer = resultItems.get("answer");
        System.out.println("answer：" + answer);

        String uuid = UUID.randomUUID().toString();

        // 将试卷问题存储到数据库
        if (title != null && content != null) {
            Wutk wutk = new Wutk();
            wutk.setContentId(uuid);
            wutk.setTitle(title.toString());
            wutk.setContent(content.toString());
            wutk.setReleaseDate(new LocalDateTime().toDate());
            int result = wutkMapper.addTestContent(wutk);
            if (result == 0) {
                System.out.println("!-----> 试卷考题保存失败");
            }
        }

        // 将答案保存到数据库
        if (answer != null) {
            // TODO: 2022/5/12 为id添加外键
            WutkAnswer wutkAnswer = new WutkAnswer();
            wutkAnswer.setContentId(uuid);
            wutkAnswer.setContent(answer.toString());
            int result = wutkAnswerMapper.addAnswerContent(wutkAnswer);
            if (result == 0) {
                System.out.println("!-----> 试卷答案保存失败");
            }
        }
    }

    // 清洗答案
//    public List<String> rinseAnswer() {
        // TODO: 2022/5/12 根据题号标注答案
//    }
}
