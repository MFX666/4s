package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author mfx
 * @since 2022-02-24
 */
@Getter
@Setter
@TableName("t_record")
@ApiModel(value = "Record对象", description = "")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("记录id")
    @JsonSerialize(using = ToStringSerializer.class)
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

    @ApiModelProperty("是否结算")//0未结算、1已结算
    @TableField("is_settlement")
    private String isSettlement;

    @ApiModelProperty("创建时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
    private Date createtime;

    @ApiModelProperty("修改时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatetime;

    @ApiModelProperty("车牌号")
    @TableField("car_brandno")
    private String carBrandno;

    @ApiModelProperty("车主姓名")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty("车主电话")
    @TableField("customer_telephone")
    private String customerTelephone;

    @TableField("company_id")
    private long companyId;

    @TableField("company_name")
    private String companyName;
}
