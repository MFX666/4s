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
          List<CarStorageVo> list = iCarStorageService.unionSearchCarStorageInfo(carStorageBody);
          return ResponseBean.success(list);
      }
    }
}
