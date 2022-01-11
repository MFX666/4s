package com.hmf.server.controller;


import com.hmf.server.entity.Car;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

import java.io.CharArrayReader;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/car")
public class CarController extends BaseController {
    @Autowired
    private ICarService iCarService;

    @GetMapping("/getCarInfoByName/{name}")
    public ResponseBean getCarInfoByName (@PathVariable String name){
        if(name==null){
            return ResponseBean.error("车名为空查询不到");
        }else {
            List<Car> cars = iCarService.getCarInfoByName(name);
            if(cars==null){
                return ResponseBean.error("未找到该车");
            }else {
                return ResponseBean.success("查询成功",cars);
            }
        }
    }
}
