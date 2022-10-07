package com.hmf.server.entity.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hmf.server.entity.Brand;
import com.hmf.server.entity.CarInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarInfoVo  {


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

    private Brand brand;
}
