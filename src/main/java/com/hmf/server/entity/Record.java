package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@Getter
@Setter
@TableName("t_record")
@ApiModel(value = "Record对象", description = "")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("记录id")
    private Long id;

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

    @ApiModelProperty("记录类型")
    @TableField("record_type")
    private String recordType;

    @ApiModelProperty("结算类型")
    @TableField("money_type")
    private String moneyType;

    @ApiModelProperty("是否结算")
    @TableField("is_settlement")
    private String isSettlement;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updatetime;

    @ApiModelProperty("客户评论")
    @TableField("customer_note")
    private String customerNote;


}
