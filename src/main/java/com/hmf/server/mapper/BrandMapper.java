package com.hmf.server.mapper;

import com.hmf.server.entity.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
public interface BrandMapper extends BaseMapper<Brand> {

    int insertBrandInfo(Brand brand);
}
