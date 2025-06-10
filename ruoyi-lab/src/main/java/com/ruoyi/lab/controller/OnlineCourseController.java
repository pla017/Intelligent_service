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
import com.ruoyi.lab.domain.OnlineCourse;
import com.ruoyi.lab.service.IOnlineCourseService;

import cn.hutool.core.lang.UUID;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 在线课程Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/onlineCourse")
public class OnlineCourseController extends BaseController
{
    @Autowired
    private IOnlineCourseService onlineCourseService;

    /**
     * 查询在线课程列表
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:list')")
    @GetMapping("/list")
    public TableDataInfo list(OnlineCourse onlineCourse)
    {
        startPage();
        List<OnlineCourse> list = onlineCourseService.selectOnlineCourseList(onlineCourse);
        return getDataTable(list);
    }

    @GetMapping("/list_onlineCourse")
    public TableDataInfo list_onlineCourse() {
        startPage();
        List<OnlineCourse> list = onlineCourseService.selectOnlineCourseList(null);
        return getDataTable(list);
    }


    /**
     * 导出在线课程列表
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:export')")
    @Log(title = "在线课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OnlineCourse onlineCourse)
    {
        List<OnlineCourse> list = onlineCourseService.selectOnlineCourseList(onlineCourse);
        ExcelUtil<OnlineCourse> util = new ExcelUtil<OnlineCourse>(OnlineCourse.class);
        util.exportExcel(response, list, "在线课程数据");
    }

    /**
     * 获取在线课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(onlineCourseService.selectOnlineCourseById(id));
    }

    /**
     * 新增在线课程
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:add')")
    @Log(title = "在线课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OnlineCourse onlineCourse)
    {
        return toAjax(onlineCourseService.insertOnlineCourse(onlineCourse));
    }

    /**
     * 修改在线课程
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:edit')")
    @Log(title = "在线课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OnlineCourse onlineCourse)
    {
        return toAjax(onlineCourseService.updateOnlineCourse(onlineCourse));
    }

    /**
     * 删除在线课程
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:remove')")
    @Log(title = "在线课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(onlineCourseService.deleteOnlineCourseByIds(ids));
    }


      /**
     * 上传人物头像
     */
    @PreAuthorize("@ss.hasPermi('lab:onlineCourse:edit')")
    @Log(title = "课程封面", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImg")
    public AjaxResult uploadImg(@RequestParam("file") MultipartFile file) throws IOException
    {
        try {
            if (file.isEmpty())
            {
                return error("上传课程封面图片不能为空");
            }
            
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新文件名
            fileName = UUID.randomUUID().toString() + suffixName;
            
            // 获取上传路径
            String avatarPath = System.getProperty("user.dir") + "/uploadPath/onlineCourse/";
            File dest = new File(avatarPath + fileName);
            
            // 检测是否存在目录
            if (!dest.getParentFile().exists())
            {
                dest.getParentFile().mkdirs();
            }
            
            // 保存文件
            file.transferTo(dest);
            
            // 返回可访问的URL路径
            String avatarUrl = "/profile/onlineCourse/" + fileName;
            return success(avatarUrl);
        } catch (Exception e) {
            logger.error("上传课程封面失败", e);
            return error("上传课程封面失败：" + e.getMessage());
        }
    }
}
