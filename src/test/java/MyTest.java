import com.guangjin.crawler.Application;
import com.guangjin.crawler.entity.Wutk;
import com.guangjin.crawler.mapper.WutkMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author jbb~
 * @version 1.0
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
public class MyTest {

    @Resource
    private WutkMapper wutkMapper;

    @Test
    public void Test() {
        wutkMapper.addTestContent(new Wutk());
    }

}
