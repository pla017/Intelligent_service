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
import com.ruoyi.lab.domain.ArticleCN;
import com.ruoyi.lab.service.IArticleCNService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章中文Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/articleCN")
public class ArticleCNController extends BaseController
{
    @Autowired
    private IArticleCNService articleCNService;

    /**
     * 查询文章中文列表
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:list')")
    @GetMapping("/list")
    public TableDataInfo list(ArticleCN articleCN)
    {
        startPage();
        List<ArticleCN> list = articleCNService.selectArticleCNList(articleCN);
        return getDataTable(list);
    }

    /**
     * 导出文章中文列表
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:export')")
    @Log(title = "文章中文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ArticleCN articleCN)
    {
        List<ArticleCN> list = articleCNService.selectArticleCNList(articleCN);
        ExcelUtil<ArticleCN> util = new ExcelUtil<ArticleCN>(ArticleCN.class);
        util.exportExcel(response, list, "文章中文数据");
    }

    /**
     * 获取文章中文详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(articleCNService.selectArticleCNById(id));
    }

    /**
     * 新增文章中文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:add')")
    @Log(title = "文章中文", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ArticleCN articleCN)
    {
        return toAjax(articleCNService.insertArticleCN(articleCN));
    }

    /**
     * 修改文章中文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:edit')")
    @Log(title = "文章中文", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ArticleCN articleCN)
    {
        return toAjax(articleCNService.updateArticleCN(articleCN));
    }

    /**
     * 删除文章中文
     */
    @PreAuthorize("@ss.hasPermi('lab:articleCN:remove')")
    @Log(title = "文章中文", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(articleCNService.deleteArticleCNByIds(ids));
    }
}
