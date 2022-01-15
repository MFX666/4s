package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
@TableName("t_car_sale_info")
@ApiModel(value = "CarSaleInfo对象", description = "")
public class CarSaleInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("车辆订单id")
    private Long id;

    @ApiModelProperty("所购车辆")
    @TableField("car_info_id")
    private Long carInfoId;

    @ApiModelProperty("备注")
    private String note;

    @ApiModelProperty("绑定企业")
    @TableField("company_id")
    private Long companyId;


}
