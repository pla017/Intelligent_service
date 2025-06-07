package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.VedioListMapper;
import com.ruoyi.lab.domain.VedioList;
import com.ruoyi.lab.service.IVedioListService;

/**
 * 视频列Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class VedioListServiceImpl implements IVedioListService 
{
    @Autowired
    private VedioListMapper vedioListMapper;

    /**
     * 查询视频列
     * 
     * @param id 视频列主键
     * @return 视频列
     */
    @Override
    public VedioList selectVedioListById(Long id)
    {
        return vedioListMapper.selectVedioListById(id);
    }

    /**
     * 查询视频列列表
     * 
     * @param vedioList 视频列
     * @return 视频列
     */
    @Override
    public List<VedioList> selectVedioListList(VedioList vedioList)
    {
        return vedioListMapper.selectVedioListList(vedioList);
    }

    /**
     * 新增视频列
     * 
     * @param vedioList 视频列
     * @return 结果
     */
    @Override
    public int insertVedioList(VedioList vedioList)
    {
        return vedioListMapper.insertVedioList(vedioList);
    }

    /**
     * 修改视频列
     * 
     * @param vedioList 视频列
     * @return 结果
     */
    @Override
    public int updateVedioList(VedioList vedioList)
    {
        return vedioListMapper.updateVedioList(vedioList);
    }

    /**
     * 批量删除视频列
     * 
     * @param ids 需要删除的视频列主键
     * @return 结果
     */
    @Override
    public int deleteVedioListByIds(Long[] ids)
    {
        return vedioListMapper.deleteVedioListByIds(ids);
    }

    /**
     * 删除视频列信息
     * 
     * @param id 视频列主键
     * @return 结果
     */
    @Override
    public int deleteVedioListById(Long id)
    {
        return vedioListMapper.deleteVedioListById(id);
    }
}
