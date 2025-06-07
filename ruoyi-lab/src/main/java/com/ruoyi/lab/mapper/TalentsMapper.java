package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.Talents;

/**
 * 人才招募Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface TalentsMapper 
{
    /**
     * 查询人才招募
     * 
     * @param id 人才招募主键
     * @return 人才招募
     */
    public Talents selectTalentsById(Long id);

    /**
     * 查询人才招募列表
     * 
     * @param talents 人才招募
     * @return 人才招募集合
     */
    public List<Talents> selectTalentsList(Talents talents);

    /**
     * 新增人才招募
     * 
     * @param talents 人才招募
     * @return 结果
     */
    public int insertTalents(Talents talents);

    /**
     * 修改人才招募
     * 
     * @param talents 人才招募
     * @return 结果
     */
    public int updateTalents(Talents talents);

    /**
     * 删除人才招募
     * 
     * @param id 人才招募主键
     * @return 结果
     */
    public int deleteTalentsById(Long id);

    /**
     * 批量删除人才招募
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTalentsByIds(Long[] ids);
}
