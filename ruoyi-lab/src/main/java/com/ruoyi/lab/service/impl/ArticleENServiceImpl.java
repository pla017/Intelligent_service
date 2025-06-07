package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.ArticleENMapper;
import com.ruoyi.lab.domain.ArticleEN;
import com.ruoyi.lab.service.IArticleENService;

/**
 * 文章英文Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class ArticleENServiceImpl implements IArticleENService 
{
    @Autowired
    private ArticleENMapper articleENMapper;

    /**
     * 查询文章英文
     * 
     * @param id 文章英文主键
     * @return 文章英文
     */
    @Override
    public ArticleEN selectArticleENById(Long id)
    {
        return articleENMapper.selectArticleENById(id);
    }

    /**
     * 查询文章英文列表
     * 
     * @param articleEN 文章英文
     * @return 文章英文
     */
    @Override
    public List<ArticleEN> selectArticleENList(ArticleEN articleEN)
    {
        return articleENMapper.selectArticleENList(articleEN);
    }

    /**
     * 新增文章英文
     * 
     * @param articleEN 文章英文
     * @return 结果
     */
    @Override
    public int insertArticleEN(ArticleEN articleEN)
    {
        return articleENMapper.insertArticleEN(articleEN);
    }

    /**
     * 修改文章英文
     * 
     * @param articleEN 文章英文
     * @return 结果
     */
    @Override
    public int updateArticleEN(ArticleEN articleEN)
    {
        return articleENMapper.updateArticleEN(articleEN);
    }

    /**
     * 批量删除文章英文
     * 
     * @param ids 需要删除的文章英文主键
     * @return 结果
     */
    @Override
    public int deleteArticleENByIds(Long[] ids)
    {
        return articleENMapper.deleteArticleENByIds(ids);
    }

    /**
     * 删除文章英文信息
     * 
     * @param id 文章英文主键
     * @return 结果
     */
    @Override
    public int deleteArticleENById(Long id)
    {
        return articleENMapper.deleteArticleENById(id);
    }
}
