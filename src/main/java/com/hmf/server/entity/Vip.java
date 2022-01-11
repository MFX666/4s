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
 * @since 2022-01-08
 */
@Getter
@Setter
@TableName("t_vip")
@ApiModel(value = "Vip对象", description = "")
public class Vip implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("会员id")
    private Long id;

    @ApiModelProperty("会员名称")
    @TableField("vip_name")
    private String vipName;

    @ApiModelProperty("会员电话号码")
    @TableField("vip_telephone")
    private String vipTelephone;

    @ApiModelProperty("余额")
    @TableField("vip_money")
    private Long vipMoney;

    @ApiModelProperty("创建时间")
    private LocalDateTime createtime;

    @ApiModelProperty("修改时间")
    private LocalDateTime updatetime;


}
