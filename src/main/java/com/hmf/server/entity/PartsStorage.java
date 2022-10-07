package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2022-01-16
 */
@Getter
@Setter
@TableName("t_parts_storage")
@ApiModel(value = "PartsStorage对象", description = "")
public class PartsStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("零件库存id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("厂家id")
    @TableField("factory_id")
    private Long factoryId;

    @ApiModelProperty("零件编号")
    @TableField("parts_number")
    private String partsNumber;

    @ApiModelProperty("零件价格")
    @TableField("parts_price")
    private BigDecimal partsPrice;

    @ApiModelProperty("是否可以使用--1--可以--0--不可以")
    @TableField("is_enable")
    private Integer isEnable;

    @ApiModelProperty("所属企业")
    @TableField("company_id")
    private Long companyId;

    @ApiModelProperty("入库时间")
    private LocalDateTime createtime;

    @ApiModelProperty("零件基本参数id")
    @TableField("parts_id")
    private Long partsId;

    @ApiModelProperty("厂家名称")
    @TableField("factory_name")
    private String factoryName;


    @ApiModelProperty("企业名称")
    @TableField("company_name")
    private String companyName;

    @ApiModelProperty("零件名称")
    @TableField("parts_name")
    private String partsName;

    @ApiModelProperty("零件分类")
    @TableField("parts_tag")
    private String partsTag;

}
