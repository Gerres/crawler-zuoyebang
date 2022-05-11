package com.guangjin.crawler.mapper;

import com.guangjin.crawler.entity.Wutk;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author jbb~
 * @version 1.0
 */
@Mapper
public interface WutkMapper {

    int addTestContent(Wutk wutk);

}
