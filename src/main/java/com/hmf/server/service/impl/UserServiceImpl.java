package com.hmf.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.Role;
import com.hmf.server.entity.User;
import com.hmf.server.mapper.UserMapper;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.security.JwtTokenUtil;
import com.hmf.server.service.IRoleService;
import com.hmf.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User getUserInfoById() {
        return userMapper.getUserInfoById();
    }

    @Override
    public ResponseBean login(String username, String password) {
        if (username == null || password == null) {
            return ResponseBean.error("参数为空");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if(null==userDetails){
            return ResponseBean.error("账号不可用");
        }
        if (null == userDetails || !password.equals(userDetails.getPassword())) {
            return ResponseBean.error("用户名或密码不正确");
        }
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, Object> resultMap = new HashMap<>();
        resultMap.put("token", token);
        resultMap.put("tokenHead", tokenHead);
        return ResponseBean.success("登录成功", resultMap);
    }

    @Override
    public User getUserByUserName(String username) {
        return this.getOne(new QueryWrapper<User>().eq("username", username).eq("is_enable", true));
    }

    @Override
    public List<Role> getRoles(Long id) {
        User user = this.getById(id);
        Role role = roleService.getById(user.getRoleId());
        List<Role> list = new ArrayList<>();
        list.add(role);
        return list;
    }


}
