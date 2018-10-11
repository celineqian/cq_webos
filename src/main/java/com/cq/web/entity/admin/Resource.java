package com.cq.web.entity.admin;

import com.alibaba.fastjson.annotation.JSONField;
import com.cq.web.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * <p>
 *     资源
 * </p>
 * Created by Celine on 30/06/2017.
 */
@Entity
@Table(name = "t_resource")
public class  Resource extends BaseEntity {


    /**
     * 资源ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = true)
    private Integer id;

    /**
     * 资源名称
     */
    private String name;

    /**
     * 资源标识
     */
    private String sourceKey;

    /**
     * 资源类型 1:目录,2: 按钮
     */
    private String type;

    /**
     * 资源URL
     */
    private String sourceUrl;

    /**
     * 层级
     */
    private String level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 图标
     */
    private String icon;

    /**
     * 是否隐藏 0:显示; 1:隐藏
     */
    private Integer isHidden;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建时间
     */
    @JSONField(format = "dd-MM-yyyy: HH:mm:ss")
    private Date createDate;

    /**
     * 修改时间
     */
    @JSONField(format = "dd-MM-yyyy: HH:mm:ss")
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Resource parent;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceKey() {
        return sourceKey;
    }

    public void setSourceKey(String sourceKey) {
        this.sourceKey = sourceKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(Integer isHidden) {
        this.isHidden = isHidden;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Resource getParent() {
        return parent;
    }

    public void setParent(Resource parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sourceKey='" + sourceKey + '\'' +
                ", type='" + type + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", level='" + level + '\'' +
                ", sort=" + sort +
                ", icon='" + icon + '\'' +
                ", isHidden=" + isHidden +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", parent=" + parent +
                '}';
    }

}
