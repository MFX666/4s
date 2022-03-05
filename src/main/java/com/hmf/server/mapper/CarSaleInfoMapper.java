package com.hmf.server.mapper;

import com.hmf.server.entity.CarSaleInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.entity.VO.CarSaleInfoVo;
import com.hmf.server.model.CarSaleInfoSearchBody;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-25
 */
public interface CarSaleInfoMapper extends BaseMapper<CarSaleInfo> {

    List<CarSaleInfoVo> unionSearchCarSaleInfo(CarSaleInfoSearchBody carSaleInfoSearchBody);

}
