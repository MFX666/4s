package com.hmf.server.mapper;

import com.hmf.server.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface UserMapper extends BaseMapper<User> {

    User getUserInfoById();
}
