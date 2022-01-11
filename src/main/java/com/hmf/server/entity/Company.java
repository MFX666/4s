package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
@TableName("t_company")
@ToString
@ApiModel(value = "Company对象", description = "")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("企业id")
    private Long id;

    @ApiModelProperty("企业名称")
    @TableField("company_name")
    private String companyName;

    @ApiModelProperty("企业地点")
    @TableField("company_address")
    private String companyAddress;

    @ApiModelProperty("企业描述")
    @TableField("company_note")
    private String companyNote;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime updatetime;

}
