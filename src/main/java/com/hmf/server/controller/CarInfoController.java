package com.hmf.server.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.CarInfo;
import com.hmf.server.entity.VO.CarInfoVo;
import com.hmf.server.model.CarInfoSearchBody;
import com.hmf.server.model.ParametersInfo;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.param.CarInfoParam;
import com.hmf.server.service.ICarInfoService;

import io.netty.util.internal.StringUtil;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
@RestController
@RequestMapping("/car-info")
public class CarInfoController extends BaseController {
    @Autowired
    private ICarInfoService iCarInfoService;

    @ApiOperation("获取所有车辆信息")
    @GetMapping("/getAllCarInfo")
    public ResponseBean getAllCarInfo() {
        List<CarInfoVo> list = iCarInfoService.getAllCarInfo();
        return ResponseBean.success(list);
    }
//    @ApiOperation("通过品牌id查找车辆")
//    @GetMapping("/getCarInfoByBrandId/{brandId}")
//    public ResponseBean getCarInfoByBrandId(@PathVariable Integer brandId) {
//        if (brandId == null) {
//            return ResponseBean.error("参数为空");
//        } else {
//            QueryWrapper<CarInfo> queryWrapper = new QueryWrapper<>();
//            queryWrapper.eq("brand_id",brandId);
//           return ResponseBean.success(iCarInfoService.list(queryWrapper));
//        }
//    }

    @ApiOperation("添加车辆信息")
    @PostMapping("/addCarInfo")
    public ResponseBean addCarInfo(@RequestBody CarInfoParam carInfoparam) {
        if (carInfoparam == null) {
            return ResponseBean.error("参数为空");
        } else {
            ParametersInfo parametersInfo = carInfoparam.getParametersInfo();
            String param = JSONUtil.toJsonStr(parametersInfo);
            CarInfo one = iCarInfoService.getOne(new QueryWrapper<CarInfo>().lambda().eq(CarInfo::getParametersInfo, param));
            if (ObjectUtil.isNotEmpty(one)) {
                throw new RuntimeException("该车辆已添加请勿重复添加");
            } else {
                CarInfo carInfo = new CarInfo();
                BeanUtils.copyProperties(carInfoparam, carInfo);
                carInfo.setParametersInfo(param);
                if (iCarInfoService.save(carInfo)) {
                    return ResponseBean.success("添加车辆信息成功");
                } else {
                    return ResponseBean.error("添加车辆信息失败");
                }
            }
        }
    }

//    @ApiOperation("通过车名查找车辆信息")
//    @GetMapping("/getCarInfoByCarName/{carName}")
//    public ResponseBean getCarInfoByCarName(@PathVariable String carName){
//        if(carName==null){
//            return ResponseBean.error("参数为空");
//        }else{
//            QueryWrapper<CarInfo> queryWrapper = new QueryWrapper<>();
//            queryWrapper.like("car_name", carName);
//            List<CarInfo> carInfos = iCarInfoService.list(queryWrapper);
//            return ResponseBean.success(carInfos);
//        }
//    }

    @ApiModelProperty("组合查询车辆信息")
    @PostMapping("/unionSearchCarInfo")
    public ResponseBean unionSearchCarInfo(@RequestBody CarInfoSearchBody carInfoSearchBody) {
        if (carInfoSearchBody == null) {
            return ResponseBean.error("参数为空");
        } else {
            List<CarInfoParam> result = new ArrayList<>();
            List<CarInfoVo> list = iCarInfoService.unionSearchCarInfo(carInfoSearchBody);
            if(CollectionUtil.isNotEmpty(list)){
                list.forEach(one ->{
                    CarInfoParam carInfoParam = new CarInfoParam();
                    String parametersInfo = one.getParametersInfo();
                    ParametersInfo parametersInfo1 = JSONUtil.toBean(parametersInfo, ParametersInfo.class);
                    BeanUtils.copyProperties(one,carInfoParam);
                    carInfoParam.setParametersInfo(parametersInfo1);
                    result.add(carInfoParam);
                });
            }
            return ResponseBean.success(result);
        }
    }

}
