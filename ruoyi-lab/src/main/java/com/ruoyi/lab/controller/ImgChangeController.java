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
import com.ruoyi.lab.domain.ImgChange;
import com.ruoyi.lab.service.IImgChangeService;

import cn.hutool.core.lang.UUID;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片切换Controller
 * 
 * @author ruoyi
 * @date 2025-06-10
 */
@RestController
@RequestMapping("/lab/imgChange")
public class ImgChangeController extends BaseController
{
    @Autowired
    private IImgChangeService imgChangeService;

    /**
     * 查询图片切换列表
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:list')")
    @GetMapping("/list")
    public TableDataInfo list(ImgChange imgChange)
    {
        startPage();
        List<ImgChange> list = imgChangeService.selectImgChangeList(imgChange);
        return getDataTable(list);
    }

    /**
     * 导出图片切换列表
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:export')")
    @Log(title = "图片切换", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ImgChange imgChange)
    {
        List<ImgChange> list = imgChangeService.selectImgChangeList(imgChange);
        ExcelUtil<ImgChange> util = new ExcelUtil<ImgChange>(ImgChange.class);
        util.exportExcel(response, list, "图片切换数据");
    }

    /**
     * 获取图片切换详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(imgChangeService.selectImgChangeById(id));
    }

    /**
     * 新增图片切换
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:add')")
    @Log(title = "图片切换", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ImgChange imgChange)
    {
        return toAjax(imgChangeService.insertImgChange(imgChange));
    }

    /**
     * 修改图片切换
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:edit')")
    @Log(title = "图片切换", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ImgChange imgChange)
    {
        return toAjax(imgChangeService.updateImgChange(imgChange));
    }

    /**
     * 删除图片切换
     */
    @PreAuthorize("@ss.hasPermi('lab:imgChange:remove')")
    @Log(title = "图片切换", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(imgChangeService.deleteImgChangeByIds(ids));
    }

     /**
     * 上传人物头像
     */

    @Log(title = "图片切换", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadImg")
    public AjaxResult uploadImg(@RequestParam("file") MultipartFile file) throws IOException
    {
        try {
            if (file.isEmpty())
            {
                return error("上传图片不能为空");
            }
            
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新文件名
            fileName = UUID.randomUUID().toString() + suffixName;
            
            // 获取上传路径
            String imgPath = System.getProperty("user.dir") + "/uploadPath/img/";
            File dest = new File(imgPath + fileName);
            
            // 检测是否存在目录
            if (!dest.getParentFile().exists())
            {
                dest.getParentFile().mkdirs();
            }
            
            // 保存文件
            file.transferTo(dest);
            
            // 返回可访问的URL路径
            String imgUrl = "/profile/img/" + fileName;
            return success(imgUrl);
        } catch (Exception e) {
            logger.error("上传图片失败", e);
            return error("上传图片失败：" + e.getMessage());
        }
    }
}
