package com.hmf.server.service.impl;

import com.hmf.server.entity.Car;
import com.hmf.server.mapper.CarMapper;
import com.hmf.server.service.ICarService;
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
 * @since 2022-01-08
 */
@Service
public class CarServiceImpl extends ServiceImpl<CarMapper, Car> implements ICarService {

    @Autowired
    private CarMapper carMapper;
    @Override
    public List<Car> getCarInfoByName(String name) {
        return  carMapper.getCarInfoByName(name);
    }
}
