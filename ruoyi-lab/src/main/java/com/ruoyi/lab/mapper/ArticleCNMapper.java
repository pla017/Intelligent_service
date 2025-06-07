package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.ArticleCN;

/**
 * 文章中文Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface ArticleCNMapper 
{
    /**
     * 查询文章中文
     * 
     * @param id 文章中文主键
     * @return 文章中文
     */
    public ArticleCN selectArticleCNById(Long id);

    /**
     * 查询文章中文列表
     * 
     * @param articleCN 文章中文
     * @return 文章中文集合
     */
    public List<ArticleCN> selectArticleCNList(ArticleCN articleCN);

    /**
     * 新增文章中文
     * 
     * @param articleCN 文章中文
     * @return 结果
     */
    public int insertArticleCN(ArticleCN articleCN);

    /**
     * 修改文章中文
     * 
     * @param articleCN 文章中文
     * @return 结果
     */
    public int updateArticleCN(ArticleCN articleCN);

    /**
     * 删除文章中文
     * 
     * @param id 文章中文主键
     * @return 结果
     */
    public int deleteArticleCNById(Long id);

    /**
     * 批量删除文章中文
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteArticleCNByIds(Long[] ids);
}
