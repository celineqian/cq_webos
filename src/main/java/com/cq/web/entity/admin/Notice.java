package com.cq.web.entity.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 *     公告
 * </p>
 * @author: Celine Q
 * @create: 2018-09-25 18:56
 **/
@Entity
@Table(name = "t_notice")
public class Notice extends BaseEntity {

    /**
     * 公告ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * 公告标题
     */
    private String title;

    /**
     * 公告内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JSONField(format = "dd-MM-yyyy: HH:mm:ss")
    private Date createDate;

    /**
     * 创建人
     */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", userId=" + userId +
                '}';
    }

}

