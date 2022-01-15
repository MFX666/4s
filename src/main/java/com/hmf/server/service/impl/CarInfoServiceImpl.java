package com.hmf.server.service.impl;

import com.hmf.server.entity.CarInfo;
import com.hmf.server.mapper.CarInfoMapper;
import com.hmf.server.service.ICarInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
@Service
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfo> implements ICarInfoService {

}
