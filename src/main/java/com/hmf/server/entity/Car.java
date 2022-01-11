package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_car")
@ApiModel(value = "Car对象", description = "")
public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车辆id")
    private Integer id;

    @ApiModelProperty("汽车名称")
    @TableField("car_name")
    private String carName;

    @ApiModelProperty("车辆图片路径")
    @TableField("car_picture")
    private String carPicture;

    @ApiModelProperty("车辆渠道")
    @TableField("car_channel")
    private String carChannel;

    @ApiModelProperty("车辆参数")
    @TableField("car_parameters")
    private String carParameters;

    @ApiModelProperty("车辆数量")
    @TableField("car_count")
    private String carCount;

    @ApiModelProperty("车辆进货价")
    @TableField("car_enter_price")
    private BigDecimal carEnterPrice;

    @ApiModelProperty("车辆销售价格")
    @TableField("car_price")
    private BigDecimal carPrice;

    @ApiModelProperty("新增时间")
    private LocalDateTime createtime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updatetime;


}
