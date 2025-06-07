package com.ruoyi.lab.controller;

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
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lab.domain.ArticleEN;
import com.ruoyi.lab.service.IArticleENService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章英文Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/articleEN")
public class ArticleENController extends BaseController
{
    @Autowired
    private IArticleENService articleENService;

    /**
     * 查询文章英文列表
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleEN articleEN)
    {
        startPage();
        List<ArticleEN> list = articleENService.selectArticleENList(articleEN);
        return getDataTable(list);
    }

    /**
     * 导出文章英文列表
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:export')")
    @Log(title = "文章英文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleEN articleEN)
    {
        List<ArticleEN> list = articleENService.selectArticleENList(articleEN);
        ExcelUtil<ArticleEN> util = new ExcelUtil<ArticleEN>(ArticleEN.class);
        util.exportExcel(response, list, "文章英文数据");
    }

    /**
     * 获取文章英文详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(articleENService.selectArticleENById(id));
    }

    /**
     * 新增文章英文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:add')")
    @Log(title = "文章英文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleEN articleEN)
    {
        return toAjax(articleENService.insertArticleEN(articleEN));
    }

    /**
     * 修改文章英文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:edit')")
    @Log(title = "文章英文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleEN articleEN)
    {
        return toAjax(articleENService.updateArticleEN(articleEN));
    }

    /**
     * 删除文章英文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleEN:remove')")
    @Log(title = "文章英文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(articleENService.deleteArticleENByIds(ids));
    }
}
