package com.ruoyi.lab.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 动态对象 dynimic
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public class Dynimic extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题图片 */
    @Excel(name = "标题图片")
    private String img;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章描述 */
    @Excel(name = "文章描述")
    private String desc;

    /** 日期时间 */
    @Excel(name = "日期时间")
    private String pDate;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setDesc(String desc) 
    {
        this.desc = desc;
    }

    public String getDesc() 
    {
        return desc;
    }
    public void setpDate(String pDate) 
    {
        this.pDate = pDate;
    }

    public String getpDate() 
    {
        return pDate;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("img", getImg())
            .append("title", getTitle())
            .append("desc", getDesc())
            .append("pDate", getpDate())
            .append("content", getContent())
            .toString();
    }
}
