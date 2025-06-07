package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.TalentsMapper;
import com.ruoyi.lab.domain.Talents;
import com.ruoyi.lab.service.ITalentsService;

/**
 * 人才招募Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class TalentsServiceImpl implements ITalentsService 
{
    @Autowired
    private TalentsMapper talentsMapper;

    /**
     * 查询人才招募
     * 
     * @param id 人才招募主键
     * @return 人才招募
     */
    @Override
    public Talents selectTalentsById(Long id)
    {
        return talentsMapper.selectTalentsById(id);
    }

    /**
     * 查询人才招募列表
     * 
     * @param talents 人才招募
     * @return 人才招募
     */
    @Override
    public List<Talents> selectTalentsList(Talents talents)
    {
        return talentsMapper.selectTalentsList(talents);
    }

    /**
     * 新增人才招募
     * 
     * @param talents 人才招募
     * @return 结果
     */
    @Override
    public int insertTalents(Talents talents)
    {
        return talentsMapper.insertTalents(talents);
    }

    /**
     * 修改人才招募
     * 
     * @param talents 人才招募
     * @return 结果
     */
    @Override
    public int updateTalents(Talents talents)
    {
        return talentsMapper.updateTalents(talents);
    }

    /**
     * 批量删除人才招募
     * 
     * @param ids 需要删除的人才招募主键
     * @return 结果
     */
    @Override
    public int deleteTalentsByIds(Long[] ids)
    {
        return talentsMapper.deleteTalentsByIds(ids);
    }

    /**
     * 删除人才招募信息
     * 
     * @param id 人才招募主键
     * @return 结果
     */
    @Override
    public int deleteTalentsById(Long id)
    {
        return talentsMapper.deleteTalentsById(id);
    }
}
