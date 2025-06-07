package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.ConcatUSMapper;
import com.ruoyi.lab.domain.ConcatUS;
import com.ruoyi.lab.service.IConcatUSService;

/**
 * 联系我们Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class ConcatUSServiceImpl implements IConcatUSService 
{
    @Autowired
    private ConcatUSMapper concatUSMapper;

    /**
     * 查询联系我们
     * 
     * @param id 联系我们主键
     * @return 联系我们
     */
    @Override
    public ConcatUS selectConcatUSById(Long id)
    {
        return concatUSMapper.selectConcatUSById(id);
    }

    /**
     * 查询联系我们列表
     * 
     * @param concatUS 联系我们
     * @return 联系我们
     */
    @Override
    public List<ConcatUS> selectConcatUSList(ConcatUS concatUS)
    {
        return concatUSMapper.selectConcatUSList(concatUS);
    }

    /**
     * 新增联系我们
     * 
     * @param concatUS 联系我们
     * @return 结果
     */
    @Override
    public int insertConcatUS(ConcatUS concatUS)
    {
        return concatUSMapper.insertConcatUS(concatUS);
    }

    /**
     * 修改联系我们
     * 
     * @param concatUS 联系我们
     * @return 结果
     */
    @Override
    public int updateConcatUS(ConcatUS concatUS)
    {
        return concatUSMapper.updateConcatUS(concatUS);
    }

    /**
     * 批量删除联系我们
     * 
     * @param ids 需要删除的联系我们主键
     * @return 结果
     */
    @Override
    public int deleteConcatUSByIds(Long[] ids)
    {
        return concatUSMapper.deleteConcatUSByIds(ids);
    }

    /**
     * 删除联系我们信息
     * 
     * @param id 联系我们主键
     * @return 结果
     */
    @Override
    public int deleteConcatUSById(Long id)
    {
        return concatUSMapper.deleteConcatUSById(id);
    }
}
