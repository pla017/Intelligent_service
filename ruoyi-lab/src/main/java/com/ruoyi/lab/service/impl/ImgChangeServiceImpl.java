package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.ImgChangeMapper;
import com.ruoyi.lab.domain.ImgChange;
import com.ruoyi.lab.service.IImgChangeService;

/**
 * 图片切换Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-10
 */
@Service
public class ImgChangeServiceImpl implements IImgChangeService 
{
    @Autowired
    private ImgChangeMapper imgChangeMapper;

    /**
     * 查询图片切换
     * 
     * @param id 图片切换主键
     * @return 图片切换
     */
    @Override
    public ImgChange selectImgChangeById(Long id)
    {
        return imgChangeMapper.selectImgChangeById(id);
    }

    /**
     * 查询图片切换列表
     * 
     * @param imgChange 图片切换
     * @return 图片切换
     */
    @Override
    public List<ImgChange> selectImgChangeList(ImgChange imgChange)
    {
        return imgChangeMapper.selectImgChangeList(imgChange);
    }

    /**
     * 新增图片切换
     * 
     * @param imgChange 图片切换
     * @return 结果
     */
    @Override
    public int insertImgChange(ImgChange imgChange)
    {
        return imgChangeMapper.insertImgChange(imgChange);
    }

    /**
     * 修改图片切换
     * 
     * @param imgChange 图片切换
     * @return 结果
     */
    @Override
    public int updateImgChange(ImgChange imgChange)
    {
        return imgChangeMapper.updateImgChange(imgChange);
    }

    /**
     * 批量删除图片切换
     * 
     * @param ids 需要删除的图片切换主键
     * @return 结果
     */
    @Override
    public int deleteImgChangeByIds(Long[] ids)
    {
        return imgChangeMapper.deleteImgChangeByIds(ids);
    }

    /**
     * 删除图片切换信息
     * 
     * @param id 图片切换主键
     * @return 结果
     */
    @Override
    public int deleteImgChangeById(Long id)
    {
        return imgChangeMapper.deleteImgChangeById(id);
    }
}
