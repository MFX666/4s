package com.hmf.server.mapper;

import com.hmf.server.entity.Parts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface PartsMapper extends BaseMapper<Parts> {

    int insertParts(Parts parts);

    int updateParts(Parts parts);
}
