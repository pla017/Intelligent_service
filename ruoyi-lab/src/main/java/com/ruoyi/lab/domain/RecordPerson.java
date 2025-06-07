package com.ruoyi.lab.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 人物志对象 recordPerson
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public class RecordPerson extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 人物名字 */
    @Excel(name = "人物名字")
    private String pName;

    /** 人物头像 */
    @Excel(name = "人物头像")
    private String avatar;

    /** 人物职位 */
    @Excel(name = "人物职位")
    private String position;

    /** 身份 */
    @Excel(name = "身份")
    private String identity;

    /** 领域 */
    @Excel(name = "领域")
    private String domain;

    /** 板块类型 */
    @Excel(name = "板块类型")
    private Long type;

    /** $column.columnComment */
    private Long id;

    public void setpName(String pName) 
    {
        this.pName = pName;
    }

    public String getpName() 
    {
        return pName;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setIdentity(String identity) 
    {
        this.identity = identity;
    }

    public String getIdentity() 
    {
        return identity;
    }
    public void setDomain(String domain) 
    {
        this.domain = domain;
    }

    public String getDomain() 
    {
        return domain;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("pName", getpName())
            .append("avatar", getAvatar())
            .append("position", getPosition())
            .append("identity", getIdentity())
            .append("domain", getDomain())
            .append("type", getType())
            .append("id", getId())
            .toString();
    }
}
