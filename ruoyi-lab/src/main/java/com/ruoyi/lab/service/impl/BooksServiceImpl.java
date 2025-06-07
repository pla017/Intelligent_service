package com.ruoyi.lab.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lab.mapper.BooksMapper;
import com.ruoyi.lab.domain.Books;
import com.ruoyi.lab.service.IBooksService;

/**
 * 幸福书屋Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@Service
public class BooksServiceImpl implements IBooksService 
{
    @Autowired
    private BooksMapper booksMapper;

    /**
     * 查询幸福书屋
     * 
     * @param id 幸福书屋主键
     * @return 幸福书屋
     */
    @Override
    public Books selectBooksById(Long id)
    {
        return booksMapper.selectBooksById(id);
    }

    /**
     * 查询幸福书屋列表
     * 
     * @param books 幸福书屋
     * @return 幸福书屋
     */
    @Override
    public List<Books> selectBooksList(Books books)
    {
        return booksMapper.selectBooksList(books);
    }

    /**
     * 新增幸福书屋
     * 
     * @param books 幸福书屋
     * @return 结果
     */
    @Override
    public int insertBooks(Books books)
    {
        return booksMapper.insertBooks(books);
    }

    /**
     * 修改幸福书屋
     * 
     * @param books 幸福书屋
     * @return 结果
     */
    @Override
    public int updateBooks(Books books)
    {
        return booksMapper.updateBooks(books);
    }

    /**
     * 批量删除幸福书屋
     * 
     * @param ids 需要删除的幸福书屋主键
     * @return 结果
     */
    @Override
    public int deleteBooksByIds(Long[] ids)
    {
        return booksMapper.deleteBooksByIds(ids);
    }

    /**
     * 删除幸福书屋信息
     * 
     * @param id 幸福书屋主键
     * @return 结果
     */
    @Override
    public int deleteBooksById(Long id)
    {
        return booksMapper.deleteBooksById(id);
    }
}
