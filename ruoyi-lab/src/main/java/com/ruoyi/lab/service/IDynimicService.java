package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.Dynimic;

/**
 * 动态Service接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface IDynimicService 
{
    /**
     * 查询动态
     * 
     * @param id 动态主键
     * @return 动态
     */
    public Dynimic selectDynimicById(Long id);

    /**
     * 查询动态列表
     * 
     * @param dynimic 动态
     * @return 动态集合
     */
    public List<Dynimic> selectDynimicList(Dynimic dynimic);

    /**
     * 新增动态
     * 
     * @param dynimic 动态
     * @return 结果
     */
    public int insertDynimic(Dynimic dynimic);

    /**
     * 修改动态
     * 
     * @param dynimic 动态
     * @return 结果
     */
    public int updateDynimic(Dynimic dynimic);

    /**
     * 批量删除动态
     * 
     * @param ids 需要删除的动态主键集合
     * @return 结果
     */
    public int deleteDynimicByIds(Long[] ids);

    /**
     * 删除动态信息
     * 
     * @param id 动态主键
     * @return 结果
     */
    public int deleteDynimicById(Long id);
}
