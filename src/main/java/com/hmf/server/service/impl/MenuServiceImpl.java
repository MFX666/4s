package com.hmf.server.service.impl;

import com.hmf.server.entity.Menu;
import com.hmf.server.entity.User;
import com.hmf.server.mapper.MenuMapper;
import com.hmf.server.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-03-07
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    @Override
    public List<Menu> getMenusByRoles() {
        return menuMapper.getMenusByRoles();
    }

    @Override
    public List<Menu> getMenuByUserId() {
        Long adminId = (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
        List<Menu> menus  =menuMapper.getMenusByAdminId(adminId);
        return menus;
    }
}
