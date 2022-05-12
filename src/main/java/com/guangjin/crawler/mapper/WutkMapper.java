package com.guangjin.crawler.mapper;

import com.guangjin.crawler.entity.Wutk;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author jbb~
 * @version 1.0
 */
@Mapper
public interface WutkMapper {

    int addTestContent(Wutk wutk);

    Wutk selectOneById(@Param("id")/*设置形参对应的别名，mapper使用#{id}获取*/ Integer id);

}
