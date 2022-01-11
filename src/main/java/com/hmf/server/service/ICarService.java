package com.hmf.server.service;

import com.hmf.server.entity.Car;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface ICarService extends IService<Car> {

    List<Car> getCarInfoByName(String name);
}
