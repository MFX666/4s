package com.hmf.server.controller;


import com.hmf.server.service.IUserRoleService;
import com.hmf.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/user-role")
public class UserRoleController extends BaseController {
    @Autowired
    private IUserRoleService iUserRoleService;

    /*
    * 1、为员工添加权限、主要是升职
    * 2、取消员工的权限
    * 3、获取权限列表
    * */
}
