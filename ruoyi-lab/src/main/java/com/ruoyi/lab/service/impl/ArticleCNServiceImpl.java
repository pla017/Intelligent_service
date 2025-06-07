package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.ArticleCNMapper;
import com.ruoyi.lab.domain.ArticleCN;
import com.ruoyi.lab.service.IArticleCNService;

/**
 * 文章中文Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class ArticleCNServiceImpl implements IArticleCNService 
{
    @Autowired
    private ArticleCNMapper articleCNMapper;

    /**
     * 查询文章中文
     * 
     * @param id 文章中文主键
     * @return 文章中文
     */
    @Override
    public ArticleCN selectArticleCNById(Long id)
    {
        return articleCNMapper.selectArticleCNById(id);
    }

    /**
     * 查询文章中文列表
     * 
     * @param articleCN 文章中文
     * @return 文章中文
     */
    @Override
    public List<ArticleCN> selectArticleCNList(ArticleCN articleCN)
    {
        return articleCNMapper.selectArticleCNList(articleCN);
    }

    /**
     * 新增文章中文
     * 
     * @param articleCN 文章中文
     * @return 结果
     */
    @Override
    public int insertArticleCN(ArticleCN articleCN)
    {
        return articleCNMapper.insertArticleCN(articleCN);
    }

    /**
     * 修改文章中文
     * 
     * @param articleCN 文章中文
     * @return 结果
     */
    @Override
    public int updateArticleCN(ArticleCN articleCN)
    {
        return articleCNMapper.updateArticleCN(articleCN);
    }

    /**
     * 批量删除文章中文
     * 
     * @param ids 需要删除的文章中文主键
     * @return 结果
     */
    @Override
    public int deleteArticleCNByIds(Long[] ids)
    {
        return articleCNMapper.deleteArticleCNByIds(ids);
    }

    /**
     * 删除文章中文信息
     * 
     * @param id 文章中文主键
     * @return 结果
     */
    @Override
    public int deleteArticleCNById(Long id)
    {
        return articleCNMapper.deleteArticleCNById(id);
    }
}
