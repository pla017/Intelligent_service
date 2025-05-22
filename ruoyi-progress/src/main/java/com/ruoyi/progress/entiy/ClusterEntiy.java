package com.ruoyi.progress.entiy;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;
import java.util.Date;


@Data
@Accessors(chain = true)
@TableName("F_CI_INTERFERE_CLUSTER")
public class ClusterEntiy {


   /*
     账期
    */
    @TableField("TIME")
    private Date time;

    /**
     * 地市
     */
    @TableField("CITY")
    private String city;


    /**
     * 干扰簇编号
     */
    @TableField("CLUSTER_NAME")
    private String clusterName;


    /**
     * 簇持续时长
     */
    @TableField("CLUSTER_LAST_LONG")
    private Integer clusterLastLong;

    /**
     * 簇内干扰小区数
     */
    @TableField("CLUSTER_C_NUM")
    private Integer clusterCNum;

    /**
     * 干扰小区信息
     */
    @TableField("CLUSTER_CI")
    private String clusterCInfo;


    /**
     * 关联场景
     */
    @TableField("SCENE_NAME")
    private String sceneName;


    /**
     * 关联干扰源
     */
    @TableField("INTERFERENCE_SOURCE")
    private String interferenceSource;


    /**
     * 实时干扰小区数
     */
    @TableField("CLUSTER_CI_NUM_NOW")
    private Integer clusterCINumNow;


    /**
     * 是否解决
     */
    @TableField("IF_DONE")
    private String ifDone;


    /**
     * 账期-前端获取时间回填
     */
    @TableField("TIME_GET")
    private Date timeGet;


    /**
     * 是否解决-前端获取时间回填
     */
    @TableField("IF_DONE_GET")
    private String ifDoneGet;


    /**
     * 实时干扰小区数-前端获取时间回填
     */
    @TableField("CLUSTE_CI_NUM_GET")
    private Integer clusterCINumGet;


    /**
     * 中心CI
     */
    @TableField("CI_CENTER")
    private String centerCI;

    /**
     * 中心小区名
     */
    @TableField("CELL_NAME_CENTER")
    private String centerCellName;


    /**
     * 簇恢复时间
     */
    @TableField("DONE_TIME")
    private Date doneTime;


    /**
     * 是否处理完族数据，1-否，2-是
     */
    @TableField("ID1")
    private Integer id1;


    /**
     * 学校名称
     */
    @TableField("SCHOOL_NAME")
    private String schoolName;

    /**
     * 区县名称
     */
    @TableField("COUNTY_NAME")
    private String countyName;


    /**
     * 回填聚簇地市派单task_id
     */
    @TableField("TASK_ID")
    private String taskId;


    /**
     * 自动化业务ID，1-起始数据，2-开始处理数据，
     */
    @TableField("ID_ZDH")
    private Integer idZdh;






}
