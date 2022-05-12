package com.guangjin.crawler.mapper;

import com.guangjin.crawler.entity.Wutk;
import com.guangjin.crawler.entity.WutkAnswer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author jbb~
 * @version 1.0
 */
@Mapper
public interface WutkAnswerMapper {

    int addAnswerContent(WutkAnswer wutkAnswer);

}
