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
@TableName("t_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单id")
    private Long id;

    @ApiModelProperty("菜单路径")
    @TableField("menu_url")
    private String menuUrl;

    @ApiModelProperty("菜单名字")
    @TableField("menu_name")
    private String menuName;

    @ApiModelProperty("父菜单id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("子菜单id")
    @TableField("children_id")
    private Long childrenId;


}
