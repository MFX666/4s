package com.hmf.server.mapper;

import com.hmf.server.entity.CarInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
public interface CarInfoMapper extends BaseMapper<CarInfo> {
    int saveCarInfo(CarInfo carInfo);
}
