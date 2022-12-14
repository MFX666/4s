package com.hmf.server.service.impl;

import com.hmf.server.entity.CarInfo;
import com.hmf.server.entity.VO.CarInfoVo;
import com.hmf.server.mapper.CarInfoMapper;
import com.hmf.server.model.CarInfoSearchBody;
import com.hmf.server.service.ICarInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    @Autowired
    private CarInfoMapper carInfoMapper;

    @Override
    public int saveCarInfo(CarInfo carInfo) {
          return carInfoMapper.saveCarInfo(carInfo);
    }

    @Override
    public List<CarInfoVo> getAllCarInfo() {

        return carInfoMapper.getAllCarInfo();
    }

    @Override
    public List<CarInfoVo> unionSearchCarInfo(CarInfoSearchBody carInfoSearchBody) {
        return carInfoMapper.unionSearchCarInfo(carInfoSearchBody);
    }
}
