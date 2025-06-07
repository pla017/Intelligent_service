package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.ArticleEN;

/**
 * 文章英文Service接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface IArticleENService 
{
    /**
     * 查询文章英文
     * 
     * @param id 文章英文主键
     * @return 文章英文
     */
    public ArticleEN selectArticleENById(Long id);

    /**
     * 查询文章英文列表
     * 
     * @param articleEN 文章英文
     * @return 文章英文集合
     */
    public List<ArticleEN> selectArticleENList(ArticleEN articleEN);

    /**
     * 新增文章英文
     * 
     * @param articleEN 文章英文
     * @return 结果
     */
    public int insertArticleEN(ArticleEN articleEN);

    /**
     * 修改文章英文
     * 
     * @param articleEN 文章英文
     * @return 结果
     */
    public int updateArticleEN(ArticleEN articleEN);

    /**
     * 批量删除文章英文
     * 
     * @param ids 需要删除的文章英文主键集合
     * @return 结果
     */
    public int deleteArticleENByIds(Long[] ids);

    /**
     * 删除文章英文信息
     * 
     * @param id 文章英文主键
     * @return 结果
     */
    public int deleteArticleENById(Long id);
}
