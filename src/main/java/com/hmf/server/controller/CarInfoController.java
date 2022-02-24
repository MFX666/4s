package com.hmf.server.controller;

import com.hmf.server.entity.CarInfo;
import com.hmf.server.entity.VO.CarInfoVo;
import com.hmf.server.model.CarInfoSearchBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICarInfoService;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseBean addCarInfo(@RequestBody CarInfo carInfo){
        if(carInfo==null){
            return ResponseBean.error("参数为空");
        }else {
            //需要判断数据库中是否有相同参数的车辆
            if(iCarInfoService.saveCarInfo(carInfo)>0){
                return ResponseBean.success("添加成功");
            }else{
                return ResponseBean.error("该车已存在请勿重复添加");
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
    public ResponseBean unionSearchCarInfo(@RequestBody CarInfoSearchBody carInfoSearchBody){
        if(carInfoSearchBody==null){
            return ResponseBean.error("参数为空");
        }else{
            List<CarInfoVo> list = iCarInfoService.unionSearchCarInfo(carInfoSearchBody);
            return ResponseBean.success(list);
        }
    }

}
