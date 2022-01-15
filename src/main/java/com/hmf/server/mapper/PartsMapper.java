package com.hmf.server.mapper;

import com.hmf.server.entity.Parts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface PartsMapper extends BaseMapper<Parts> {

    List<Parts> getPartsInfoByName(String name);


    List<Parts> getPartsInfoByTag();
}
