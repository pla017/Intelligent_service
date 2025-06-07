package com.ruoyi.lab.service;

import java.util.List;
import com.ruoyi.lab.domain.Books;

/**
 * 幸福书屋Service接口
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
public interface IBooksService 
{
    /**
     * 查询幸福书屋
     * 
     * @param id 幸福书屋主键
     * @return 幸福书屋
     */
    public Books selectBooksById(Long id);

    /**
     * 查询幸福书屋列表
     * 
     * @param books 幸福书屋
     * @return 幸福书屋集合
     */
    public List<Books> selectBooksList(Books books);

    /**
     * 新增幸福书屋
     * 
     * @param books 幸福书屋
     * @return 结果
     */
    public int insertBooks(Books books);

    /**
     * 修改幸福书屋
     * 
     * @param books 幸福书屋
     * @return 结果
     */
    public int updateBooks(Books books);

    /**
     * 批量删除幸福书屋
     * 
     * @param ids 需要删除的幸福书屋主键集合
     * @return 结果
     */
    public int deleteBooksByIds(Long[] ids);

    /**
     * 删除幸福书屋信息
     * 
     * @param id 幸福书屋主键
     * @return 结果
     */
    public int deleteBooksById(Long id);
}
