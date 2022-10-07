package com.hmf.server.param;

import lombok.Data;

import java.util.List;

/**
 * @author humengfan
 * @since 2022年05月04日 19:39
 */
@Data
public class RoleMenuParam {
    private Long roleId;
    private List<Long> menuId;
}
