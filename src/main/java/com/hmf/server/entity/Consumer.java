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
 * @since 2022-05-04
 */
@Getter
@Setter
@TableName("t_consumer")
@ApiModel(value = "Consumer对象", description = "")
public class Consumer implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("客户id")
    @JsonSerialize(using = ToStringSerializer.class)
    private Long id;

    @ApiModelProperty("客户名称")
    @TableField("consumer_name")
    private String consumerName;

    @ApiModelProperty("客户联系方式")
    @TableField("consumer_telephone")
    private String consumerTelephone;

    @ApiModelProperty("企业")
    @TableField("company_id")
    private Long companyId;


}
