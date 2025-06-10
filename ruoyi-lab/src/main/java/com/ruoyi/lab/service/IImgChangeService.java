package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.ImgChange;

/**
 * 图片切换Service接口
 * 
 * @author ruoyi
 * @date 2025-06-10
 */
public interface IImgChangeService 
{
    /**
     * 查询图片切换
     * 
     * @param id 图片切换主键
     * @return 图片切换
     */
    public ImgChange selectImgChangeById(Long id);

    /**
     * 查询图片切换列表
     * 
     * @param imgChange 图片切换
     * @return 图片切换集合
     */
    public List<ImgChange> selectImgChangeList(ImgChange imgChange);

    /**
     * 新增图片切换
     * 
     * @param imgChange 图片切换
     * @return 结果
     */
    public int insertImgChange(ImgChange imgChange);

    /**
     * 修改图片切换
     * 
     * @param imgChange 图片切换
     * @return 结果
     */
    public int updateImgChange(ImgChange imgChange);

    /**
     * 批量删除图片切换
     * 
     * @param ids 需要删除的图片切换主键集合
     * @return 结果
     */
    public int deleteImgChangeByIds(Long[] ids);

    /**
     * 删除图片切换信息
     * 
     * @param id 图片切换主键
     * @return 结果
     */
    public int deleteImgChangeById(Long id);
}
