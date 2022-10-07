package com.hmf.server.security;

import com.hmf.server.entity.Menu;
import com.hmf.server.entity.Role;
import com.hmf.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

@Component
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private IMenuService menuService;
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> menus = menuService.getMenusByRoles();
        for (Menu menu : menus) {
            if(antPathMatcher.match(menu.getUrl(),requestUrl)){
                String[] strings = menu.getRoles().stream().map(Role::getRoleName).toArray(String[]::new);
                return SecurityConfig.createList(strings);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
