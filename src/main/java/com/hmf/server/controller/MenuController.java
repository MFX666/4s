package com.hmf.server.controller;


import com.hmf.server.entity.Menu;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IMenuService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-03-07
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private IMenuService menuService;
    @ApiModelProperty("获取所有菜单")
    @RequestMapping("/getAllMenus")
    public ResponseBean getAllMenus(){
        return ResponseBean.success(menuService.getAllMenus());
    }


    @ApiModelProperty("通过用户id获取菜单")
    @GetMapping("/getMenuByUserId")
    public List<Menu> getMenuByUserId(){
        return menuService.getMenuByUserId();
    }
}
