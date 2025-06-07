package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.DynimicMapper;
import com.ruoyi.lab.domain.Dynimic;
import com.ruoyi.lab.service.IDynimicService;

/**
 * 动态Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class DynimicServiceImpl implements IDynimicService 
{
    @Autowired
    private DynimicMapper dynimicMapper;

    /**
     * 查询动态
     * 
     * @param id 动态主键
     * @return 动态
     */
    @Override
    public Dynimic selectDynimicById(Long id)
    {
        return dynimicMapper.selectDynimicById(id);
    }

    /**
     * 查询动态列表
     * 
     * @param dynimic 动态
     * @return 动态
     */
    @Override
    public List<Dynimic> selectDynimicList(Dynimic dynimic)
    {
        return dynimicMapper.selectDynimicList(dynimic);
    }

    /**
     * 新增动态
     * 
     * @param dynimic 动态
     * @return 结果
     */
    @Override
    public int insertDynimic(Dynimic dynimic)
    {
        return dynimicMapper.insertDynimic(dynimic);
    }

    /**
     * 修改动态
     * 
     * @param dynimic 动态
     * @return 结果
     */
    @Override
    public int updateDynimic(Dynimic dynimic)
    {
        return dynimicMapper.updateDynimic(dynimic);
    }

    /**
     * 批量删除动态
     * 
     * @param ids 需要删除的动态主键
     * @return 结果
     */
    @Override
    public int deleteDynimicByIds(Long[] ids)
    {
        return dynimicMapper.deleteDynimicByIds(ids);
    }

    /**
     * 删除动态信息
     * 
     * @param id 动态主键
     * @return 结果
     */
    @Override
    public int deleteDynimicById(Long id)
    {
        return dynimicMapper.deleteDynimicById(id);
    }
}
