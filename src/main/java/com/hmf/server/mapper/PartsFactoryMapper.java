package com.hmf.server.mapper;

import com.hmf.server.entity.PartsFactory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface PartsFactoryMapper extends BaseMapper<PartsFactory> {

    int insertPartsFactory(PartsFactory partsFactory);

    int update(PartsFactory partsFactory);
}
