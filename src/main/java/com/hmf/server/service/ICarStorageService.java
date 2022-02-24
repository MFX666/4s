package com.hmf.server.service;

import com.hmf.server.entity.CarStorage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.entity.VO.CarStorageVo;
import com.hmf.server.model.CarStorageBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-24
 */
public interface ICarStorageService extends IService<CarStorage> {

    List<CarStorageVo> unionSearchCarStorageInfo(CarStorageBody carStorageBody);

    int updateEnableById(Long[] ids);
}
