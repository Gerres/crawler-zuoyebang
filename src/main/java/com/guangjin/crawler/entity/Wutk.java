package com.guangjin.crawler.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @author jbb~
 * @version 1.0
 */
@TableName("wutk_test")
public class Wutk {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String contentId;

    private String title;

    private String content;

    private Date releaseDate;

    public Wutk() {
    }

    public Wutk(Integer id, String contentId, String title, String content, Date releaseDate) {
        this.id = id;
        this.contentId = contentId;
        this.title = title;
        this.content = content;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
