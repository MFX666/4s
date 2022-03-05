package com.hmf.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.CarSaleInfo;
import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.VO.CarSaleInfoVo;
import com.hmf.server.mapper.CarSaleInfoMapper;
import com.hmf.server.model.CarSaleInfoSearchBody;
import com.hmf.server.service.ICarSaleInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hmf.server.service.ICarStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-25
 */
@Service
public class CarSaleInfoServiceImpl extends ServiceImpl<CarSaleInfoMapper, CarSaleInfo> implements ICarSaleInfoService {
    @Autowired
    private CarSaleInfoMapper carSaleInfoMapper;
    @Autowired
    private ICarStorageService carStorageService;
    @Override
    public List<CarSaleInfoVo> unionSearchCarSaleInfo(CarSaleInfoSearchBody carSaleInfoSearchBody) {
        return carSaleInfoMapper.unionSearchCarSaleInfo(carSaleInfoSearchBody);
    }
    /*
    * 1、判断该车辆是否是可售卖状态
    * 2、添加订单之后改变可售卖状态
    * */
    @Override
    public Map<String,Object> addCarSaleInfo(CarSaleInfo carSaleInfo) {
        Map<String,Object> result = new HashMap<>();
        CarStorage carStorage = carStorageService.getById(carSaleInfo.getCarStorageId());
        if(carStorage==null) {
            result.put("message", "查无此车");
            result.put("code", 1);
        }
        if(carStorage.getIsEnable()==0) {
            result.put("message","该车已售卖");
            result.put("code", 1);
        }
        if(this.save(carSaleInfo)){
            carStorage.setIsEnable(0);
            carStorageService.updateById(carStorage);
            result.put("code",0);
        }
        return result;
    }
}
