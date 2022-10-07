package com.hmf.server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

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
 * @since 2022-03-07
 */
@Getter
@Setter
@ToString
@TableName("t_menu")
@ApiModel(value = "Menu对象", description = "")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单id")
    private Long id;

    @ApiModelProperty("菜单路径")
    private String url;

    @ApiModelProperty("菜单路由")
    private String path;

    @ApiModelProperty("组件名")
    private String component;

    @ApiModelProperty("菜单名")
    private String name;

    @ApiModelProperty("父id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("是否可用 1--可用 ，2--不可用")
    private Boolean enabled;

    @ApiModelProperty("子菜单")
    @TableField(exist = false)
    private List<Menu> children;

    @ApiModelProperty("角色列表")
    @TableField(exist = false)
    private List<Role> roles;

}
