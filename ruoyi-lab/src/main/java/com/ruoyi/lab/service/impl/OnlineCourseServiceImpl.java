package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.OnlineCourseMapper;
import com.ruoyi.lab.domain.OnlineCourse;
import com.ruoyi.lab.service.IOnlineCourseService;

/**
 * 在线课程Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class OnlineCourseServiceImpl implements IOnlineCourseService 
{
    @Autowired
    private OnlineCourseMapper onlineCourseMapper;

    /**
     * 查询在线课程
     * 
     * @param id 在线课程主键
     * @return 在线课程
     */
    @Override
    public OnlineCourse selectOnlineCourseById(Long id)
    {
        return onlineCourseMapper.selectOnlineCourseById(id);
    }

    /**
     * 查询在线课程列表
     * 
     * @param onlineCourse 在线课程
     * @return 在线课程
     */
    @Override
    public List<OnlineCourse> selectOnlineCourseList(OnlineCourse onlineCourse)
    {
        return onlineCourseMapper.selectOnlineCourseList(onlineCourse);
    }

    /**
     * 新增在线课程
     * 
     * @param onlineCourse 在线课程
     * @return 结果
     */
    @Override
    public int insertOnlineCourse(OnlineCourse onlineCourse)
    {
        return onlineCourseMapper.insertOnlineCourse(onlineCourse);
    }

    /**
     * 修改在线课程
     * 
     * @param onlineCourse 在线课程
     * @return 结果
     */
    @Override
    public int updateOnlineCourse(OnlineCourse onlineCourse)
    {
        return onlineCourseMapper.updateOnlineCourse(onlineCourse);
    }

    /**
     * 批量删除在线课程
     * 
     * @param ids 需要删除的在线课程主键
     * @return 结果
     */
    @Override
    public int deleteOnlineCourseByIds(Long[] ids)
    {
        return onlineCourseMapper.deleteOnlineCourseByIds(ids);
    }

    /**
     * 删除在线课程信息
     * 
     * @param id 在线课程主键
     * @return 结果
     */
    @Override
    public int deleteOnlineCourseById(Long id)
    {
        return onlineCourseMapper.deleteOnlineCourseById(id);
    }
}
