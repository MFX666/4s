package com.hmf.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hmf.server.entity.Role;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/role")
public class RoleController extends BaseController {
    @Autowired
    private IRoleService iRoleService;

    /**
     * @return
     * 获取所有角色信息
     */
    @GetMapping("/getAllRoleInfo")
    public ResponseBean getAllRoleInfo(){
        return ResponseBean.success("获取成功",iRoleService.list(new LambdaQueryWrapper<Role>().ne(Role::getRoleName,"ROLE_ADMIN")));
    }

    /**
     * @param role
     * @return
     * 添加角色
     */
    @PostMapping("/addRole")
    public ResponseBean addRole(@RequestBody Role role){
        if(role==null){
            return  ResponseBean.error("角色为空，不能添加");
        }else{
            if(iRoleService.save(role)){
                return ResponseBean.success("添加角色成功");
            }else{
                return ResponseBean.error("添加角色失败");
            }
        }
    }


}
