package com.hmf.server.service;

import com.hmf.server.entity.CarSaleInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.entity.VO.CarSaleInfoVo;
import com.hmf.server.model.CarSaleInfoSearchBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-25
 */
public interface ICarSaleInfoService extends IService<CarSaleInfo> {

    List<CarSaleInfoVo> unionSearchCarSaleInfo(CarSaleInfoSearchBody carSaleInfoSearchBody);

    Map<String,Object> addCarSaleInfo(CarSaleInfo carSaleInfo);
}
