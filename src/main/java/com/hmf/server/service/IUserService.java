package com.hmf.server.service;

import com.hmf.server.entity.Role;
import com.hmf.server.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.model.LoginBody;
import com.hmf.server.model.ResponseBean;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface IUserService extends IService<User> {
    User getUserInfoById();



    ResponseBean login(String username,String password);

    User getUserByUserName(String username);

    List<Role> getRoles(Long id);
}
