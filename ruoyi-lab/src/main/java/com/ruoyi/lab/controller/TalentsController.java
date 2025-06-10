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
import com.ruoyi.lab.domain.Talents;
import com.ruoyi.lab.service.ITalentsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 人才招募Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/talents")
public class TalentsController extends BaseController
{
    @Autowired
    private ITalentsService talentsService;

    /**
     * 查询人才招募列表
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:list')")
    @GetMapping("/list")
    public TableDataInfo list(Talents talents)
    {
        startPage();
        List<Talents> list = talentsService.selectTalentsList(talents);
        return getDataTable(list);
    }

    @GetMapping("/list_talents")
    public TableDataInfo list_talents() {
        startPage();
        List<Talents> list = talentsService.selectTalentsList(null);
        return getDataTable(list);
    }

    /**
     * 导出人才招募列表
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:export')")
    @Log(title = "人才招募", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Talents talents)
    {
        List<Talents> list = talentsService.selectTalentsList(talents);
        ExcelUtil<Talents> util = new ExcelUtil<Talents>(Talents.class);
        util.exportExcel(response, list, "人才招募数据");
    }

    /**
     * 获取人才招募详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(talentsService.selectTalentsById(id));
    }

    /**
     * 新增人才招募
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:add')")
    @Log(title = "人才招募", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Talents talents)
    {
        return toAjax(talentsService.insertTalents(talents));
    }

    /**
     * 修改人才招募
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:edit')")
    @Log(title = "人才招募", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Talents talents)
    {
        return toAjax(talentsService.updateTalents(talents));
    }

    /**
     * 删除人才招募
     */
    @PreAuthorize("@ss.hasPermi('lab:talents:remove')")
    @Log(title = "人才招募", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(talentsService.deleteTalentsByIds(ids));
    }
}
