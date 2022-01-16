package com.hmf.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.CarParameter;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICarParameterService;
import com.hmf.server.utils.filter.RepeatFilterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
@RestController
@Api("汽车参数常量管理")
@RequestMapping("/car-parameter")
public class CarParameterController extends BaseController {
    @Autowired
    private ICarParameterService iCarParameterService;
    @Autowired
    private RepeatFilterService parameterFilter;
    @ApiModelProperty("获取所有的汽车参数信息")
    @GetMapping("/getAllParameters")
    public ResponseBean getAllParameters(){
        return ResponseBean.success(iCarParameterService.list());
    }
    @ApiModelProperty("通过分类标签获取汽车参数信息 ")
    @GetMapping("/getParametersByTag/{tag}")
    public ResponseBean getParametersByTag(@PathVariable String tag){
        if(tag==null){
            return ResponseBean.error("参数为空");
        }else {
            QueryWrapper<CarParameter> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parameter_tag",tag);
            return ResponseBean.success(iCarParameterService.list(queryWrapper));
        }
    }

}
