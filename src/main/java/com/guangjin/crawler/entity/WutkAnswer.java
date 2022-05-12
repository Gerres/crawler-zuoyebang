package com.guangjin.crawler.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author jbb~
 * @version 1.0
 */
@TableName("wutk_answer")
public class WutkAnswer {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String contentId;
    private String content;

    public WutkAnswer() {
    }

    public WutkAnswer(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
