package com.hmf.server.mapper;

import com.hmf.server.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-03-07
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getAllMenus();

    List<Menu> getMenusByRoles();

    List<Menu> getMenusByAdminId(@Param("adminId") Long adminId);
}
