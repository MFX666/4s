package com.hmf.server.param;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author humengfan
 * @since 2022年05月02日 22:58
 */
@Data
public class RecordParam {
    @ApiModelProperty("维修描述/检测描述")
    @TableField("record_name")
    private String recordName;

    @ApiModelProperty("维修耗材")
    @TableField("record_note")
    private String recordNote;

    @ApiModelProperty("维修员工/检查员工")
    @TableField("repair_staff")
    private String repairStaff;

    @ApiModelProperty("维修金额/检测金额")
    @TableField("repair_money")
    private String repairMoney;

    @ApiModelProperty("修改时间")
    private LocalDateTime updatetime;

    @ApiModelProperty("车牌号")
    @TableField("car_brandno")
    private String carBrandno;

    @ApiModelProperty("车主姓名")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("车主电话")
    @TableField("customer_telephone")
    private String customerTelephone;
}
