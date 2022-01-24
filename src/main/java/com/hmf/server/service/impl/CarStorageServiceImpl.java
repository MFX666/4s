package com.hmf.server.service.impl;

import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.VO.CarStorageVo;
import com.hmf.server.mapper.CarStorageMapper;
import com.hmf.server.model.CarStorageBody;
import com.hmf.server.service.ICarStorageService;
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
 * @since 2022-01-24
 */
@Service
public class CarStorageServiceImpl extends ServiceImpl<CarStorageMapper, CarStorage> implements ICarStorageService {
    @Autowired
    private CarStorageMapper carStorageMapper;
    @Override
    public List<CarStorageVo> unionSearchCarStorageInfo(CarStorageBody carStorageBody) {
        return carStorageMapper.unionSearchCarStorageInfo(carStorageBody);
    }
}
