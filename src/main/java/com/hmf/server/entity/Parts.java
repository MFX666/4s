package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
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
@TableName("t_parts")
@ApiModel(value = "Parts对象", description = "")
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("零件id")
    private Long id;

    @ApiModelProperty("零件名称")
    @TableField("parts_name")
    private String partsName;

    @ApiModelProperty("零件分类")
    @TableField("parts_tag")
    private String partsTag;


}
