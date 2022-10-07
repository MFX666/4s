package com.hmf.server.controller;


import com.hmf.server.entity.CarSaleInfo;
import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.VO.CarSaleInfoVo;
import com.hmf.server.model.CarSaleInfoSearchBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICarSaleInfoService;
import com.hmf.server.service.ICarStorageService;
import com.hmf.server.service.impl.CarStorageServiceImpl;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import io.swagger.annotations.ApiModelProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;
import sun.nio.cs.ArrayEncoder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-25
 * <p>
 * 有待优化
 * 车辆id从库存中获取
 * 生成订单之后，车辆信息is_enable =0 取消改为1
 * 生成订单之前判断车辆id的is_enable 是否为1;
 */
@RestController
@RequestMapping("/car-sale")
@Slf4j
public class CarSaleInfoController extends BaseController {
    //新增车辆订单
    //删除车辆订单
    //查询车辆订单
    //修改车辆订单
    @Autowired
    private ICarSaleInfoService carSaleInfoService;
    @Autowired
    private ICarStorageService carStorageService;

    @ApiModelProperty("新增车辆订单")
    @PostMapping("/addCarSaleInfo")
    public ResponseBean addCarSaleInfo(@RequestBody CarSaleInfo carSaleInfo) {
        if (carSaleInfo == null) return ResponseBean.error("参数为空");
        carSaleInfo.setCreatetime(LocalDateTime.now());
        //有待优化
        Map<String, Object> map = carSaleInfoService.addCarSaleInfo(carSaleInfo);
        if ((int) map.get("code") == 0) return ResponseBean.success("订单添加成功");
        return ResponseBean.error(map.get("message").toString());
    }

    /*
     * 企业id查询
     * 联系人查询
     * 联系人电话查询
     *
     * */
    @ApiModelProperty("查询车辆订单")
    @PostMapping("/unionSearchCarSaleInfo")
    public ResponseBean unionSearchCarSaleInfo(@RequestBody CarSaleInfoSearchBody carSaleInfoSearchBody) {
        if (carSaleInfoSearchBody == null) return ResponseBean.error("参数为空");
        List<CarSaleInfoVo> carSalInfoVoList = carSaleInfoService.unionSearchCarSaleInfo(carSaleInfoSearchBody);
        if (carSalInfoVoList == null) return ResponseBean.error("暂无此车辆信息");
        return ResponseBean.success(carSalInfoVoList);
    }

    @ApiModelProperty("修改车辆订单信息")
    @PostMapping("/updateCarSaleInfo")
    public ResponseBean updateCarSaleInfo(@RequestBody CarSaleInfo carSaleInfo) {
        if (carSaleInfo == null) {
            return ResponseBean.error("参数为空");
        }
        if ("已结算".equals(carSaleInfoService.getById(carSaleInfo).getIsSettlement())){
            return ResponseBean.success("已结算订单不能修改");

        }
        if (carSaleInfoService.updateById(carSaleInfo)){
            return ResponseBean.success("修改成功");
        }
        return ResponseBean.error("修改失败,请联系管理员");
    }

    @ApiModelProperty("删除车辆订单信息")
    @DeleteMapping("/deleteCarSaleInfo/{id}")
    public ResponseBean deleteCarSaleInfo(@PathVariable Integer id) {
        if (id == null) return ResponseBean.error("参数为空");
        CarSaleInfo target = carSaleInfoService.getById(id);
        if ("已结算".equals(target.getIsSettlement())) return ResponseBean.error("订单已结算无法删除");
        if (carSaleInfoService.removeById(id)) {
            CarStorage carStorage = carStorageService.getById(target.getCarStorageId());
            carStorage.setIsEnable(1);
            carStorageService.updateById(carStorage);
            return ResponseBean.success("订单删除成功");
        }
        return ResponseBean.error("订单删除失败，请联系管理员");
    }

    @ApiModelProperty("结算订单")
    @GetMapping("/payMoney/{id}")
    public ResponseBean payMoney(@PathVariable("id") Long id) {
        if (id == null) {
            return ResponseBean.error("参数为空");
        }
        CarSaleInfo target = carSaleInfoService.getById(id);
        if ("已结算".equals(target.getIsSettlement())) {
            return ResponseBean.error("已结算请勿重复结算");
        }
        CarStorage carStorage = carStorageService.getById(target.getCarStorageId());
        carStorage.setIsEnable(0);
        target.setIsSettlement("已结算");
        if (carStorageService.updateById(carStorage)&&carSaleInfoService.updateById(target)) {
            return ResponseBean.success("结算成功");
        }
        return ResponseBean.error("结算失败请联系管理员");
    }
}
