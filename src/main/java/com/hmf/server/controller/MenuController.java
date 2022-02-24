package com.hmf.server.controller;


import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IMenuService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController {
    @Autowired
    private IMenuService iMenuService;


    @ApiModelProperty("获取所有菜单")
    @GetMapping("/getAllMenus")
    public ResponseBean getAllMenus(){
        return ResponseBean.success(iMenuService.list());
    }
}
