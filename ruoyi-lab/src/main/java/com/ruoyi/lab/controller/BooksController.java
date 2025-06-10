package com.ruoyi.lab.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lab.domain.Books;
import com.ruoyi.lab.service.IBooksService;

import cn.hutool.core.lang.UUID;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 幸福书屋Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/books")
public class BooksController extends BaseController
{
    @Autowired
    private IBooksService booksService;

    /**
     * 查询幸福书屋列表
     */
    @PreAuthorize("@ss.hasPermi('lab:books:list')")
    @GetMapping("/list")
    public TableDataInfo list(Books books)
    {
        startPage();
        List<Books> list = booksService.selectBooksList(books);
        return getDataTable(list);
    }

    @GetMapping("/list_books")
    public TableDataInfo list_books() {
        startPage();
        List<Books> list = booksService.selectBooksList(null);
        return getDataTable(list);
    }

    /**
     * 导出幸福书屋列表
     */
    @PreAuthorize("@ss.hasPermi('lab:books:export')")
    @Log(title = "幸福书屋", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Books books)
    {
        List<Books> list = booksService.selectBooksList(books);
        ExcelUtil<Books> util = new ExcelUtil<Books>(Books.class);
        util.exportExcel(response, list, "幸福书屋数据");
    }

    /**
     * 获取幸福书屋详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:books:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(booksService.selectBooksById(id));
    }

    /**
     * 新增幸福书屋
     */
    @PreAuthorize("@ss.hasPermi('lab:books:add')")
    @Log(title = "幸福书屋", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Books books)
    {
        return toAjax(booksService.insertBooks(books));
    }

    /**
     * 修改幸福书屋
     */
    @PreAuthorize("@ss.hasPermi('lab:books:edit')")
    @Log(title = "幸福书屋", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Books books)
    {
        return toAjax(booksService.updateBooks(books));
    }

    /**
     * 删除幸福书屋
     */
    @PreAuthorize("@ss.hasPermi('lab:books:remove')")
    @Log(title = "幸福书屋", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(booksService.deleteBooksByIds(ids));
    }
     /**
     * 上传书本图片
     */
    @Log(title = "书本图片", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImage")
    public AjaxResult uploadImage(@RequestParam("file") MultipartFile file) throws IOException
    {
        try {
            if (file.isEmpty())
            {
                return error("上传书本图片不能为空");
            }
            
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新文件名
            fileName = UUID.randomUUID().toString() + suffixName;
            
            // 获取上传路径
            String avatarPath = System.getProperty("user.dir") + "/uploadPath/books/";
            File dest = new File(avatarPath + fileName);
            
            // 检测是否存在目录
            if (!dest.getParentFile().exists())
            {
                dest.getParentFile().mkdirs();
            }
            
            // 保存文件
            file.transferTo(dest);
            
            // 返回可访问的URL路径
            String avatarUrl = "/profile/books/" + fileName;
            return success(avatarUrl);
        } catch (Exception e) {
            logger.error("上传头像失败", e);
            return error("上传头像失败：" + e.getMessage());
        }
    }
}
