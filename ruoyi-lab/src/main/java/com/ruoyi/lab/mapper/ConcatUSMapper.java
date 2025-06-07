package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.ConcatUS;

/**
 * 联系我们Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface ConcatUSMapper 
{
    /**
     * 查询联系我们
     * 
     * @param id 联系我们主键
     * @return 联系我们
     */
    public ConcatUS selectConcatUSById(Long id);

    /**
     * 查询联系我们列表
     * 
     * @param concatUS 联系我们
     * @return 联系我们集合
     */
    public List<ConcatUS> selectConcatUSList(ConcatUS concatUS);

    /**
     * 新增联系我们
     * 
     * @param concatUS 联系我们
     * @return 结果
     */
    public int insertConcatUS(ConcatUS concatUS);

    /**
     * 修改联系我们
     * 
     * @param concatUS 联系我们
     * @return 结果
     */
    public int updateConcatUS(ConcatUS concatUS);

    /**
     * 删除联系我们
     * 
     * @param id 联系我们主键
     * @return 结果
     */
    public int deleteConcatUSById(Long id);

    /**
     * 批量删除联系我们
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteConcatUSByIds(Long[] ids);
}
