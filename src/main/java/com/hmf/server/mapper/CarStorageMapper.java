package com.hmf.server.mapper;

import com.hmf.server.entity.CarStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.entity.VO.CarStorageVo;
import com.hmf.server.model.CarStorageBody;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-24
 */
public interface CarStorageMapper extends BaseMapper<CarStorage> {

    List<CarStorageVo> unionSearchCarStorageInfo(CarStorageBody carStorageBody);

    int updateEnableById(Long[] ids);
}
