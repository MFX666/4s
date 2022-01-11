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
@TableName("t_parts")
@ApiModel(value = "Parts对象", description = "")
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("零件id")
    private Long id;

    @ApiModelProperty("零件名称")
    @TableField("parts_name")
    private String partsName;

    @ApiModelProperty("零件渠道")
    @TableField("parts_channel")
    private String partsChannel;

    @ApiModelProperty("零件数量")
    @TableField("parts_count")
    private Long partsCount;

    @ApiModelProperty("零件进货价")
    @TableField("parts_enter_price")
    private BigDecimal partsEnterPrice;

    @ApiModelProperty("零件售价")
    @TableField("parts_price")
    private BigDecimal partsPrice;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updatetime;


}
