package com.hmf.server.service;

import com.hmf.server.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
