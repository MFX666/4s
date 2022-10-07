package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
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
 * @since 2022-01-24
 */
@Getter
@Setter
@TableName("t_car_storage")
@ApiModel(value = "CarStorage对象", description = "")
public class CarStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty("车辆库存id")
    private Long id;

    @ApiModelProperty("车辆信息id")
    @TableField("car_Info_id")
    private Long carInfoId;

    @ApiModelProperty("关联公司id")
    @TableField("company_id")
    private Long companyId;

    @ApiModelProperty("能否被售卖--1-可以-0不可以")
    @TableField("is_enable")
    private Integer isEnable;

    @ApiModelProperty("入库时间")
    private LocalDateTime createtime;


}
