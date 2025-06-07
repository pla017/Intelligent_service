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
import com.ruoyi.lab.domain.VedioList;
import com.ruoyi.lab.service.IVedioListService;

import cn.hutool.core.lang.UUID;

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


      /**
     * 上传书本图片
     */
    @Log(title = "视频封面", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImage")
    public AjaxResult uploadImage(@RequestParam("file") MultipartFile file) throws IOException
    {
        try {
            if (file.isEmpty())
            {
                return error("上传视频封面不能为空");
            }
            
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新文件名
            fileName = UUID.randomUUID().toString() + suffixName;
            
            // 获取上传路径
            String avatarPath = System.getProperty("user.dir") + "/uploadPath/vedio/";
            File dest = new File(avatarPath + fileName);
            
            // 检测是否存在目录
            if (!dest.getParentFile().exists())
            {
                dest.getParentFile().mkdirs();
            }
            
            // 保存文件
            file.transferTo(dest);
            
            // 返回可访问的URL路径
            String avatarUrl = "/profile/vedio/" + fileName;
            return success(avatarUrl);
        } catch (Exception e) {
            logger.error("上传头像失败", e);
            return error("上传头像失败：" + e.getMessage());
        }
    }
}
