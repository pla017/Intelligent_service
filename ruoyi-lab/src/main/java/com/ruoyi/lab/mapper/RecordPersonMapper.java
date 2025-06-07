package com.ruoyi.lab.mapper;

import java.util.List;
import com.ruoyi.lab.domain.RecordPerson;

/**
 * 人物志Mapper接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface RecordPersonMapper 
{
    /**
     * 查询人物志
     * 
     * @param id 人物志主键
     * @return 人物志
     */
    public RecordPerson selectRecordPersonById(Long id);

    /**
     * 查询人物志列表
     * 
     * @param recordPerson 人物志
     * @return 人物志集合
     */
    public List<RecordPerson> selectRecordPersonList(RecordPerson recordPerson);

    /**
     * 新增人物志
     * 
     * @param recordPerson 人物志
     * @return 结果
     */
    public int insertRecordPerson(RecordPerson recordPerson);

    /**
     * 修改人物志
     * 
     * @param recordPerson 人物志
     * @return 结果
     */
    public int updateRecordPerson(RecordPerson recordPerson);

    /**
     * 删除人物志
     * 
     * @param id 人物志主键
     * @return 结果
     */
    public int deleteRecordPersonById(Long id);

    /**
     * 批量删除人物志
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteRecordPersonByIds(Long[] ids);
}
