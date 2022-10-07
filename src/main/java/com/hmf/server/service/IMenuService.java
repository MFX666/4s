package com.hmf.server.service;

import com.hmf.server.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-03-07
 */
public interface IMenuService extends IService<Menu> {

    List<Menu> getAllMenus();

    List<Menu> getMenusByRoles();

    List<Menu> getMenuByUserId();

}
