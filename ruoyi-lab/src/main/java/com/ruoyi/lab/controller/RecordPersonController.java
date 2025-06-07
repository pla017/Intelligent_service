package com.ruoyi.lab.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lab.domain.RecordPerson;
import com.ruoyi.lab.service.IRecordPersonService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.file.FileUtils;

/**
 * 人物志Controller
 * 
 * @author ruoyi
 * @date 2025-06-07
 */
@RestController
@RequestMapping("/lab/recordPerson")
public class RecordPersonController extends BaseController
{
    private static final Logger logger = LoggerFactory.getLogger(RecordPersonController.class);

    @Autowired
    private IRecordPersonService recordPersonService;

    /**
     * 查询人物志列表
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:list')")
    @GetMapping("/list")
    public TableDataInfo list(RecordPerson recordPerson)
    {
        startPage();
        List<RecordPerson> list = recordPersonService.selectRecordPersonList(recordPerson);
        return getDataTable(list);
    }

    /**
     * 导出人物志列表
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:export')")
    @Log(title = "人物志", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RecordPerson recordPerson)
    {
        List<RecordPerson> list = recordPersonService.selectRecordPersonList(recordPerson);
        ExcelUtil<RecordPerson> util = new ExcelUtil<RecordPerson>(RecordPerson.class);
        util.exportExcel(response, list, "人物志数据");
    }

    /**
     * 获取人物志详细信息
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(recordPersonService.selectRecordPersonById(id));
    }

    /**
     * 新增人物志
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:add')")
    @Log(title = "人物志", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RecordPerson recordPerson)
    {
        return toAjax(recordPersonService.insertRecordPerson(recordPerson));
    }

    /**
     * 修改人物志
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:edit')")
    @Log(title = "人物志", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RecordPerson recordPerson)
    {
        return toAjax(recordPersonService.updateRecordPerson(recordPerson));
    }

    /**
     * 删除人物志
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:remove')")
    @Log(title = "人物志", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(recordPersonService.deleteRecordPersonByIds(ids));
    }

    /**
     * 上传人物头像
     */
    @PreAuthorize("@ss.hasPermi('lab:recordPerson:edit')")
    @Log(title = "人物头像", businessType = BusinessType.UPDATE)
    @PostMapping("/uploadAvatar")
    public AjaxResult uploadAvatar(@RequestParam("file") MultipartFile file) throws IOException
    {
        try {
            if (file.isEmpty())
            {
                return error("上传头像图片不能为空");
            }
            
            // 获取文件名
            String fileName = file.getOriginalFilename();
            // 获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            // 生成新文件名
            fileName = UUID.randomUUID().toString() + suffixName;
            
            // 获取上传路径
            String avatarPath = System.getProperty("user.dir") + "/uploadPath/avatar/";
            File dest = new File(avatarPath + fileName);
            
            // 检测是否存在目录
            if (!dest.getParentFile().exists())
            {
                dest.getParentFile().mkdirs();
            }
            
            // 保存文件
            file.transferTo(dest);
            
            // 返回可访问的URL路径
            String avatarUrl = "/profile/avatar/" + fileName;
            return success(avatarUrl);
        } catch (Exception e) {
            logger.error("上传头像失败", e);
            return error("上传头像失败：" + e.getMessage());
        }
    }
}
