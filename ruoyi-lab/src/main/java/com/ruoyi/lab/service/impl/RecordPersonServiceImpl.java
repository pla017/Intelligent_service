package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.RecordPersonMapper;
import com.ruoyi.lab.domain.RecordPerson;
import com.ruoyi.lab.service.IRecordPersonService;

/**
 * 人物志Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class RecordPersonServiceImpl implements IRecordPersonService 
{
    @Autowired
    private RecordPersonMapper recordPersonMapper;

    /**
     * 查询人物志
     * 
     * @param id 人物志主键
     * @return 人物志
     */
    @Override
    public RecordPerson selectRecordPersonById(Long id)
    {
        return recordPersonMapper.selectRecordPersonById(id);
    }

    /**
     * 查询人物志列表
     * 
     * @param recordPerson 人物志
     * @return 人物志
     */
    @Override
    public List<RecordPerson> selectRecordPersonList(RecordPerson recordPerson)
    {
        return recordPersonMapper.selectRecordPersonList(recordPerson);
    }

    /**
     * 新增人物志
     * 
     * @param recordPerson 人物志
     * @return 结果
     */
    @Override
    public int insertRecordPerson(RecordPerson recordPerson)
    {
        return recordPersonMapper.insertRecordPerson(recordPerson);
    }

    /**
     * 修改人物志
     * 
     * @param recordPerson 人物志
     * @return 结果
     */
    @Override
    public int updateRecordPerson(RecordPerson recordPerson)
    {
        return recordPersonMapper.updateRecordPerson(recordPerson);
    }

    /**
     * 批量删除人物志
     * 
     * @param ids 需要删除的人物志主键
     * @return 结果
     */
    @Override
    public int deleteRecordPersonByIds(Long[] ids)
    {
        return recordPersonMapper.deleteRecordPersonByIds(ids);
    }

    /**
     * 删除人物志信息
     * 
     * @param id 人物志主键
     * @return 结果
     */
    @Override
    public int deleteRecordPersonById(Long id)
    {
        return recordPersonMapper.deleteRecordPersonById(id);
    }
}
