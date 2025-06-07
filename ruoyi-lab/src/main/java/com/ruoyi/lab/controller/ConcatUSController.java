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
import com.ruoyi.lab.domain.ConcatUS;
import com.ruoyi.lab.service.IConcatUSService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 联系我们Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/concatUS")
public class ConcatUSController extends BaseController
{
    @Autowired
    private IConcatUSService concatUSService;

    /**
     * 查询联系我们列表
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:list')")
    @GetMapping("/list")
    public TableDataInfo list(ConcatUS concatUS)
    {
        startPage();
        List<ConcatUS> list = concatUSService.selectConcatUSList(concatUS);
        return getDataTable(list);
    }

    /**
     * 导出联系我们列表
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:export')")
    @Log(title = "联系我们", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ConcatUS concatUS)
    {
        List<ConcatUS> list = concatUSService.selectConcatUSList(concatUS);
        ExcelUtil<ConcatUS> util = new ExcelUtil<ConcatUS>(ConcatUS.class);
        util.exportExcel(response, list, "联系我们数据");
    }

    /**
     * 获取联系我们详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(concatUSService.selectConcatUSById(id));
    }

    /**
     * 新增联系我们
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:add')")
    @Log(title = "联系我们", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ConcatUS concatUS)
    {
        return toAjax(concatUSService.insertConcatUS(concatUS));
    }

    /**
     * 修改联系我们
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:edit')")
    @Log(title = "联系我们", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ConcatUS concatUS)
    {
        return toAjax(concatUSService.updateConcatUS(concatUS));
    }

    /**
     * 删除联系我们
     */
    @PreAuthorize("@ss.hasPermi('lab:concatUS:remove')")
    @Log(title = "联系我们", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(concatUSService.deleteConcatUSByIds(ids));
    }
}
