package com.ruoyi.progress.service.impl;



import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.progress.entiy.ClusterEntiy;
import com.ruoyi.progress.entiy.WhiteList;
import com.ruoyi.progress.mapper.ClusterMapper;
import com.ruoyi.progress.service.IClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ClusterService extends ServiceImpl<ClusterMapper, ClusterEntiy> implements IClusterService {


    @Override
    public JSONObject cluster4GHandle(MultipartFile file) {
        JSONObject result=new JSONObject();
        //读取白名单信息
        try {
            EasyExcel.read(file.getInputStream(), WhiteList.class, new ReadListener<WhiteList>() {

                @Override
                public void invoke(WhiteList data, AnalysisContext context) {
                    // 处理读取到的数据（如保存到数据库、计算统计信息等）
                    System.out.println("白名单信息: " + JSON.toJSONString(data));
                    LambdaQueryWrapper<ClusterEntiy> queryWrapper=new LambdaQueryWrapper<>();
                    queryWrapper
                            .eq(ClusterEntiy::getCenterCI,data.getCi())
                            .eq(ClusterEntiy::getCenterCellName,data.getCellName())
                            .eq(ClusterEntiy::getCity,data.getCity())
                            .eq(ClusterEntiy::getCountyName,data.getCounty())
                            .eq(ClusterEntiy::getCenterCellName,data.getInterferenceSource());
                    List<ClusterEntiy> list = list(queryWrapper);
                    //TODO 生产工单标题和工单内容到工作台三期
                    System.out.println("过滤后白名单信息"+JSON.toJSONString(list));
                }

                @Override
                public void doAfterAllAnalysed(AnalysisContext analysisContext) {

                }


            }).sheet().doRead();

        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
