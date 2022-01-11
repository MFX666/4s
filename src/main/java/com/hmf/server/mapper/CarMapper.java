package com.hmf.server.mapper;

import com.hmf.server.entity.Car;
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
public interface CarMapper extends BaseMapper<Car> {

    List<Car> getCarInfoByName(String name);
}
