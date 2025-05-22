package com.ruoyi.progress.entiy;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * 用户提交白名单
 */
@Data
public class WhiteList {

    @ExcelProperty(value = "日期")
    private String date;

    @ExcelProperty(value = "地市")
    private String city;

    @ExcelProperty(value = "区县")
    private String county;

    @ExcelProperty(value = "CI")
    private String ci;

    @ExcelProperty(value = "小区名")
    private String cellName;

    @ExcelProperty(value = "干扰源信息")
    private String interferenceSource;


}
