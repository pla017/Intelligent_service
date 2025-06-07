package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.OnlineCourse;

/**
 * 在线课程Service接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface IOnlineCourseService 
{
    /**
     * 查询在线课程
     * 
     * @param id 在线课程主键
     * @return 在线课程
     */
    public OnlineCourse selectOnlineCourseById(Long id);

    /**
     * 查询在线课程列表
     * 
     * @param onlineCourse 在线课程
     * @return 在线课程集合
     */
    public List<OnlineCourse> selectOnlineCourseList(OnlineCourse onlineCourse);

    /**
     * 新增在线课程
     * 
     * @param onlineCourse 在线课程
     * @return 结果
     */
    public int insertOnlineCourse(OnlineCourse onlineCourse);

    /**
     * 修改在线课程
     * 
     * @param onlineCourse 在线课程
     * @return 结果
     */
    public int updateOnlineCourse(OnlineCourse onlineCourse);

    /**
     * 批量删除在线课程
     * 
     * @param ids 需要删除的在线课程主键集合
     * @return 结果
     */
    public int deleteOnlineCourseByIds(Long[] ids);

    /**
     * 删除在线课程信息
     * 
     * @param id 在线课程主键
     * @return 结果
     */
    public int deleteOnlineCourseById(Long id);
}
