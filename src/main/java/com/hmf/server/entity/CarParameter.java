package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("t_car_parameter")
@ApiModel(value = "CarParameter对象", description = "")
public class CarParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("参数id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("参数名称")
    @TableField("parameter_name")
    private String parameterName;

    @ApiModelProperty("参数分类")
    @TableField("parameter_tag")
    private String parameterTag;


}
