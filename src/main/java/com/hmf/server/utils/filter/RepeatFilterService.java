package com.hmf.server.utils.filter;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.CarInfo;
import com.hmf.server.entity.Parts;
import com.hmf.server.service.ICarInfoService;
import com.hmf.server.service.IPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RepeatFilterService {
    @Autowired
    private  ICarInfoService iCarInfoService;
    @Autowired
    private IPartsService iPartsService;
    public  boolean checkDBCarInfo(CarInfo carInfo){
        QueryWrapper<CarInfo> carNameWrapper = new QueryWrapper<>();
        carNameWrapper.eq("car_name",carInfo.getCarName());
        List<CarInfo> list = iCarInfoService.list(carNameWrapper);
        if(list.size()==0){
            return false;
        }else{
            for (CarInfo info : list) {
                if(info.getParametersInfo().equals(carInfo.getParametersInfo())){
                    return true;
                }
            }
            return false;
        }
    }

    public boolean checkDBParts(Parts parts) {
        QueryWrapper partsWrapper = new QueryWrapper();
        partsWrapper.eq("parts_name",parts.getPartsName());
        Parts one = iPartsService.getOne(partsWrapper);
        if(one==null){
            return false;
        }
        return true;
    }
}
