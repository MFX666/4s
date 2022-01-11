package com.hmf.server.service.impl;

import com.hmf.server.entity.User;
import com.hmf.server.mapper.UserMapper;
import com.hmf.server.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfoById() {
        return userMapper.getUserInfoById();
    }
}
