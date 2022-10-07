package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

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
 * @since 2022-01-16
 */
@Getter
@Setter
@TableName("t_parts_factory")
@ApiModel(value = "PartsFactory对象", description = "")
public class PartsFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("零部件厂家id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("厂家名称")
    @TableField("factory_name")
    private String factoryName;

    @ApiModelProperty("厂家地址")
    @TableField("factory_address")
    private String factoryAddress;

    @ApiModelProperty("厂家联系电话")
    @TableField("factory_telephone")
    private String factoryTelephone;


}
