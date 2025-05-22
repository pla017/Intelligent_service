package com.ruoyi.progress.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.progress.service.IClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 突发干扰蔟流程迁移，自动结点，自动评估
 */
@RequestMapping("/burst")
@RestController
public class ClusterController {

    @Autowired
    private IClusterService iClusterService;


    @RequestMapping("/assess")
    public AjaxResult assess(MultipartFile file) {
        return AjaxResult.success(iClusterService.cluster4GHandle(file));
    }
}
