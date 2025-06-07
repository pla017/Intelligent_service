package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.VedioList;

/**
 * 视频列Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface VedioListMapper 
{
    /**
     * 查询视频列
     * 
     * @param id 视频列主键
     * @return 视频列
     */
    public VedioList selectVedioListById(Long id);

    /**
     * 查询视频列列表
     * 
     * @param vedioList 视频列
     * @return 视频列集合
     */
    public List<VedioList> selectVedioListList(VedioList vedioList);

    /**
     * 新增视频列
     * 
     * @param vedioList 视频列
     * @return 结果
     */
    public int insertVedioList(VedioList vedioList);

    /**
     * 修改视频列
     * 
     * @param vedioList 视频列
     * @return 结果
     */
    public int updateVedioList(VedioList vedioList);

    /**
     * 删除视频列
     * 
     * @param id 视频列主键
     * @return 结果
     */
    public int deleteVedioListById(Long id);

    /**
     * 批量删除视频列
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteVedioListByIds(Long[] ids);
}
