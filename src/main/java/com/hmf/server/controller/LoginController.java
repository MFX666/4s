package com.hmf.server.controller;

import com.hmf.server.entity.Company;
import com.hmf.server.entity.User;
import com.hmf.server.model.LoginBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICompanyService;
import com.hmf.server.service.IUserService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ICompanyService companyService;
    /*
    * 登录之后返回token
    * */
    @ApiModelProperty("用户登录")
    @PostMapping("/login")
    public ResponseBean login(@RequestBody LoginBody loginBody){
        return userService.login(loginBody.getUsername(),loginBody.getPassword());
    }

    @ApiOperation(value = "获取当前用户登录信息")
    @RequestMapping("/userInfo")
    public HashMap<String,Object> getAdminInfo(Principal principal){
        if(null == principal){
            return  null;
        }
        HashMap<String,Object> map = new HashMap<>();
        //获取用户信息
        String username = principal.getName();
        User user = userService.getUserByUserName(username);
        user.setPassword(null);
        user.setRoles(userService.getRoles(user.getId()));
        //获取品牌信息
        Long companyId = user.getCompanyId();
        if(companyId!=null){
            Company company = companyService.getById(companyId);
            Long brandId = company.getBrandId();
            map.put("user",user);
            map.put("brandId",brandId);
        }else{
            map.put("user",user);
        }
        return map;
    }

}
