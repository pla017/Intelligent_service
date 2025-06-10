package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.ImgChange;

/**
 * 图片切换Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-10
 */
public interface ImgChangeMapper 
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
     * 删除图片切换
     * 
     * @param id 图片切换主键
     * @return 结果
     */
    public int deleteImgChangeById(Long id);

    /**
     * 批量删除图片切换
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteImgChangeByIds(Long[] ids);
}
