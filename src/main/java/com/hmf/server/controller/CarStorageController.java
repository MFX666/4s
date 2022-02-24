package com.hmf.server.controller;


import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.VO.CarStorageVo;
import com.hmf.server.model.CarStorageBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICarStorageService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-24
 */
@RestController
@RequestMapping("/car-storage")
public class CarStorageController extends BaseController {
    @Autowired
    private ICarStorageService iCarStorageService;

    @ApiModelProperty("车辆库存情况组合查询")
    @PostMapping("unionSearchCarStorageInfo")
    public ResponseBean unionSearchCarStorageInfo(@RequestBody CarStorageBody carStorageBody) {
      if(carStorageBody==null){
          return ResponseBean.error("参数为空");
      }else{
          //默认查询可用
          carStorageBody.setIsEnable(1);
          List<CarStorageVo> list = iCarStorageService.unionSearchCarStorageInfo(carStorageBody);
          return ResponseBean.success(list);
      }
    }

    @ApiModelProperty("车辆入库")
    @PostMapping("/insertCarStorage")
    public ResponseBean insertCarStorage(@RequestBody List<CarStorage> carStorage){
        if(carStorage==null){
            return ResponseBean.error("参数为空");
        }else{
            for (CarStorage storage : carStorage) {
                storage.setCreatetime(LocalDateTime.now());
            }
            if(iCarStorageService.saveBatch(carStorage)){
                return ResponseBean.success("车辆入库成功");
            }else {
                return ResponseBean.error("车辆入库失败");
            }
        }
    }

    @ApiModelProperty("车辆出库")
    @PostMapping("companyCarStorageOut")
    public ResponseBean companyCarStorageOut(@RequestBody Long[] ids){
        if(ids==null){
            return ResponseBean.error("参数为空");
        }else{
            if(iCarStorageService.updateEnableById(ids)==ids.length){
                return ResponseBean.success("出库成功");
            }else{
                return ResponseBean.error("出库失败");
            }
        }
    }
}
