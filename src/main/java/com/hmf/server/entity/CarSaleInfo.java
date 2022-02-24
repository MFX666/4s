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
 * @since 2022-01-25
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
    @TableField("car_storage_id")
    private Long carStorageId;

    @ApiModelProperty("销售员工id")
    @TableField("sale_man_id")
    private Long saleManId;

    @ApiModelProperty("购买人")
    @TableField("buy_man_name")
    private String buyManName;

    @ApiModelProperty("购买时间")
    private LocalDateTime createtime;

    @ApiModelProperty("购买方式")
    @TableField("buy_type")
    private String buyType;

    @ApiModelProperty("备注")
    private String note;


}
