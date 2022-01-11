package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

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
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("用户真实姓名")
    @TableField("real_name")
    private String realName;

    @ApiModelProperty("用户登录账号")
    @TableField("user_name")
    private String userName;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime createtime;

    @ApiModelProperty("更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private LocalDateTime updatetime;

    @ApiModelProperty("电话号码")
    private String telephone;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("职位")
    private String position;

    @ApiModelProperty("身份证号码")
    @TableField("id_card")
    private String idCard;

    @ApiModelProperty("入职时间")
    @TableField("enter_time")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date enterTime;

    @ApiModelProperty("关联店铺")
    @TableField("company_id")
    private Long companyId;
}
