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
import com.ruoyi.lab.domain.VedioList;
import com.ruoyi.lab.service.IVedioListService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频列Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/vedioList")
public class VedioListController extends BaseController
{
    @Autowired
    private IVedioListService vedioListService;

    /**
     * 查询视频列列表
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:list')")
    @GetMapping("/list")
    public TableDataInfo list(VedioList vedioList)
    {
        startPage();
        List<VedioList> list = vedioListService.selectVedioListList(vedioList);
        return getDataTable(list);
    }

    /**
     * 导出视频列列表
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:export')")
    @Log(title = "视频列", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, VedioList vedioList)
    {
        List<VedioList> list = vedioListService.selectVedioListList(vedioList);
        ExcelUtil<VedioList> util = new ExcelUtil<VedioList>(VedioList.class);
        util.exportExcel(response, list, "视频列数据");
    }

    /**
     * 获取视频列详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(vedioListService.selectVedioListById(id));
    }

    /**
     * 新增视频列
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:add')")
    @Log(title = "视频列", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VedioList vedioList)
    {
        return toAjax(vedioListService.insertVedioList(vedioList));
    }

    /**
     * 修改视频列
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:edit')")
    @Log(title = "视频列", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody VedioList vedioList)
    {
        return toAjax(vedioListService.updateVedioList(vedioList));
    }

    /**
     * 删除视频列
     */
    @PreAuthorize("@ss.hasPermi('lab:vedioList:remove')")
    @Log(title = "视频列", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(vedioListService.deleteVedioListByIds(ids));
    }
}
