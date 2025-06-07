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
import com.ruoyi.lab.domain.Dynimic;
import com.ruoyi.lab.service.IDynimicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 动态Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/dynimic")
public class DynimicController extends BaseController
{
    @Autowired
    private IDynimicService dynimicService;

    /**
     * 查询动态列表
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:list')")
    @GetMapping("/list")
    public TableDataInfo list(Dynimic dynimic)
    {
        startPage();
        List<Dynimic> list = dynimicService.selectDynimicList(dynimic);
        return getDataTable(list);
    }

    /**
     * 导出动态列表
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:export')")
    @Log(title = "动态", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Dynimic dynimic)
    {
        List<Dynimic> list = dynimicService.selectDynimicList(dynimic);
        ExcelUtil<Dynimic> util = new ExcelUtil<Dynimic>(Dynimic.class);
        util.exportExcel(response, list, "动态数据");
    }

    /**
     * 获取动态详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dynimicService.selectDynimicById(id));
    }

    /**
     * 新增动态
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:add')")
    @Log(title = "动态", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Dynimic dynimic)
    {
        return toAjax(dynimicService.insertDynimic(dynimic));
    }

    /**
     * 修改动态
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:edit')")
    @Log(title = "动态", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Dynimic dynimic)
    {
        return toAjax(dynimicService.updateDynimic(dynimic));
    }

    /**
     * 删除动态
     */
    @PreAuthorize("@ss.hasPermi('lab:dynimic:remove')")
    @Log(title = "动态", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dynimicService.deleteDynimicByIds(ids));
    }
}
