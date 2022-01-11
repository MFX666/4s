package com.hmf.server.controller;


import com.hmf.server.entity.User;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
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
    @PostMapping("/add")
    public ResponseBean addUser(@RequestBody User user){
        if(user==null) {
           return ResponseBean.error("员工信息为空");
        }else {
            System.out.println(user.getEnterTime());
            user.setCreatetime(LocalDateTime.now());
            user.setUpdatetime(LocalDateTime.now());

            if(userService.save(user)){
                return ResponseBean.success("添加员工成功");
            }
        }

        return ResponseBean.error("添加员工失败");
    }
    @PostMapping("/updateUser")
    public ResponseBean updateUser(@RequestBody User user){
        if(user==null){
            return ResponseBean.error("参数为空修改失败");
        }else{
            user.setUpdatetime(LocalDateTime.now());
            if(userService.updateById(user)){
                return ResponseBean.success("修改成功");
            }
        }
        return ResponseBean.error("修改失败");
    }
    @GetMapping("/allUser")
    public ResponseBean getAllUser(){
        List<User> list = userService.list();
        return ResponseBean.success(list);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseBean deleteUser(@PathVariable Integer id){
        if(id==null){
            return ResponseBean.error("id为空删除失败");
        }else {
            if(userService.removeById(id)){
                return ResponseBean.success("删除成功");
            }
        }
        return ResponseBean.error("删除失败");
    }
}
