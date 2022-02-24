package com.hmf.server.service;

import com.hmf.server.entity.CarInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.entity.VO.CarInfoVo;
import com.hmf.server.model.CarInfoSearchBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
public interface ICarInfoService extends IService<CarInfo> {

    int saveCarInfo(CarInfo carInfo);

    List<CarInfoVo> getAllCarInfo();

    List<CarInfoVo> unionSearchCarInfo(CarInfoSearchBody carInfoSearchBody);
}
