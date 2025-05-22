package com.ruoyi.progress.service;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.progress.entiy.ClusterEntiy;
import org.springframework.web.multipart.MultipartFile;

public interface IClusterService extends IService<ClusterEntiy> {


    /**
     * 4G干扰蔟自动评估
     */
    JSONObject cluster4GHandle(MultipartFile file);
}
