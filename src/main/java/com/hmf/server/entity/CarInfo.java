package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;

import com.hmf.server.model.ParametersInfo;
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
 * @since 2022-01-15
 */
@Getter
@Setter
@TableName("t_car_info")
@ApiModel(value = "CarInfo对象", description = "")
public class CarInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车辆基本信息id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("汽车名称")
    @TableField("car_name")
    private String carName;

    @ApiModelProperty("车辆图片路径")
    @TableField("car_picture_url")
    private String carPictureUrl;

    @ApiModelProperty("车辆销售价格")
    @TableField("car_price")
    private BigDecimal carPrice;

    @ApiModelProperty("车辆分类")
    @TableField("car_tag")
    private String carTag;

    @ApiModelProperty("车辆品牌")
    @TableField("brand_id")
    private Long brandId;

    @ApiModelProperty("车辆参数信息")
    @TableField("parameters_info")
    private String parametersInfo;


}
