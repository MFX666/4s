package com.hmf.server.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.MenuRole;
import com.hmf.server.entity.Role;
import com.hmf.server.entity.User;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.param.RoleMenuParam;
import com.hmf.server.param.UpdatePasswordParam;
import com.hmf.server.service.IMenuRoleService;
import com.hmf.server.service.IRoleService;
import com.hmf.server.service.IUserService;
import com.hmf.server.vo.UserVo;
import com.mysql.cj.xdevapi.UpdateParams;
import org.apache.catalina.security.SecurityUtil;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.reactive.context.ReactiveWebApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.http.SecurityHeaders;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;
import sun.awt.image.ImageWatched;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IMenuRoleService menuRoleService;

    @PostMapping("/addUser")
    public ResponseBean addUser(@RequestBody User user) {
        if (user == null) {
            return ResponseBean.error("员工信息为空");
        }
        User dbUser = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername()));
        if (ObjectUtil.isNotEmpty(dbUser)) {
            return ResponseBean.error("登录名重复");
        }

        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        user.setCompanyId(loginUser.getCompanyId());
        user.setCreatetime(LocalDateTime.now());
        user.setUpdatetime(LocalDateTime.now());
        Role role = roleService.getById(user.getRoleId());
        String position = role.getRoleRealName();
        user.setPosition(position);
        user.setPassword("123456");
        user.setEnterTime(new Date());
        user.setEnable(Boolean.TRUE);
        if (userService.save(user)) {
            return ResponseBean.success("添加员工成功");
        }
        return ResponseBean.error("添加员工失败");
    }

    @PostMapping("/updateUser")
    public ResponseBean updateUser(@RequestBody User user) {
        if (user == null) {
            return ResponseBean.error("参数为空修改失败");
        } else {
            user.setUpdatetime(LocalDateTime.now());
            if (userService.updateById(user)) {
                return ResponseBean.success("修改成功");
            }
        }
        return ResponseBean.error("修改失败");
    }

    @GetMapping("/allUser")
    public ResponseBean getAllUser() {
        List<User> list = userService.list();
        List<UserVo> vo = new LinkedList<>();
        list.forEach(user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            vo.add(userVo);
        });
        return ResponseBean.success(vo);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseBean deleteUser(@PathVariable Integer id) {
        if (id == null) {
            return ResponseBean.error("id为空删除失败");
        } else {
            if (userService.removeById(id)) {
                return ResponseBean.success("删除成功");
            }
        }
        return ResponseBean.error("删除失败");
    }

    /**
     * 通过登录用户公司id查看员工信息
     *
     * @return
     */
    @GetMapping("/getCompanyUser")
    public ResponseBean getCompanyUser() {
        Long companyId = (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCompanyId());
        List<User> users = userService.list(new LambdaQueryWrapper<User>().eq(User::getCompanyId, companyId));
        List<UserVo> vo = new LinkedList<>();
        users.forEach(user -> {
            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(user, userVo);
            vo.add(userVo);
        });
        return ResponseBean.success(vo);
    }

    @GetMapping("/stop/{id}")
    public ResponseBean stop(@PathVariable("id") Long id) {
        User dbUser = userService.getById(id);
        if (!dbUser.getEnable()) {
            return ResponseBean.error("该账号已停用");
        }
        dbUser.setEnable(Boolean.FALSE);
        if (userService.updateById(dbUser)) {
            return ResponseBean.success("账号停用成功");
        }
        return ResponseBean.error("停用失败");
    }

    @GetMapping("/start/{id}")
    public ResponseBean start(@PathVariable("id") Long id) {
        User dbUser = userService.getById(id);
        if (dbUser.getEnable()) {
            return ResponseBean.error("该账号正在使用");
        }
        dbUser.setEnable(Boolean.TRUE);
        if (userService.updateById(dbUser)) {
            return ResponseBean.success("账号启用成功");
        }
        return ResponseBean.error("启用失败");

    }

    @PostMapping("/updatePassword")
    public ResponseBean updatePassword(@PathVariable UpdatePasswordParam param) {
        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        String password = loginUser.getPassword();
        User user = new User();
        if (param.getOldOne().equals(password)) {
            user.setId(loginUser.getId());
            user.setPassword(param.getNewOne());
        }else{
            return ResponseBean.error("旧密码不对，请重新输入");
        }
        if ( userService.updateById(user)){
            return ResponseBean.success("修改密码成功");
        }
        return ResponseBean.error("修改密码失败");
    }

    @PostMapping("/register")
    public ResponseBean register(@RequestBody User param){
        User user = new User();
        User one = userService.getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, param.getUsername()));
        if (ObjectUtil.isNotEmpty(one)) {
            return ResponseBean.error("此用户名已存在");
        }
        BeanUtils.copyProperties(param,user);
        user.setId(new Snowflake().nextId());
        user.setRoleId(14L);
        user.setPosition("客户");
        user.setEnable(Boolean.TRUE);
        user.setCreatetime(LocalDateTime.now());
        user.setUpdatetime(LocalDateTime.now());
        if(userService.save(user)){
            return ResponseBean.success("注册成功");
        }
        return ResponseBean.error("注册失败");
    }

    @PostMapping("/deliverMenu")
    public ResponseBean deliverMenu(@RequestBody RoleMenuParam param){
        //删掉老的权限菜单
        menuRoleService.remove(new LambdaQueryWrapper<MenuRole>().eq(MenuRole::getRoleId, param.getRoleId()));
        List<MenuRole> list = new ArrayList<>();
        List<Long> menuId = param.getMenuId();
        if(CollectionUtil.isNotEmpty(menuId)){
            menuId.forEach(one->{
                MenuRole menuRole = new MenuRole();
                menuRole.setMenuId(one);
                menuRole.setRoleId(param.getRoleId());
                list.add(menuRole);
            });
        }
        if(menuRoleService.saveBatch(list)){
            return ResponseBean.success("分配权限成功");
        }else{
            return ResponseBean.error("分配权限失败");
        }
    }
}
