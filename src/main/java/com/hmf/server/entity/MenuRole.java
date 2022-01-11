package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2022-01-08
 */
@Getter
@Setter
@TableName("t_menu_role")
@ApiModel(value = "MenuRole对象", description = "")
public class MenuRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单权限id")
    private Long id;

    @ApiModelProperty("菜单id")
    @TableField("menu_id")
    private Long menuId;

    @ApiModelProperty("权限id")
    @TableField("role_id")
    private Long roleId;


}
