package com.hmf.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.PartsStorage;
import com.hmf.server.entity.VO.PartsStorageVO;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IPartsStorageService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
@RestController
@RequestMapping("/parts-storage")
public class PartsStorageController extends BaseController {
    @Autowired
    private IPartsStorageService partsStorageService;
    
    @ApiModelProperty("获取所有可用零件库存信息")
    @GetMapping("/getAllPartsStorageInfo")
    public ResponseBean getAllPartsStorageInfo(){
        QueryWrapper <PartsStorage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_enable",1);
        return ResponseBean.success(partsStorageService.list(queryWrapper));
    }
    @ApiModelProperty("通过公司id获取所有可用零件库存")
    @GetMapping("/getEnablePartsStorageByCompanyId/{companyId}")
    public ResponseBean getEnablePartsStorageByCompanyId(@PathVariable Long companyId){
        List<PartsStorageVO> list = partsStorageService.getPartsStorageByCompanyId(companyId);
        return ResponseBean.success(list);
    }
    @ApiModelProperty("通过公司id获取所有不可用零件库存")
    @GetMapping("/getPartsStorageByCompanyId/{companyId}")
    public ResponseBean getUnEnablePartsStorageByCompanyId(@PathVariable Long companyId){
        if(companyId==null){
            return ResponseBean.error("参数为空");
        }else{
            QueryWrapper<PartsStorage> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("company_id",companyId);
            queryWrapper.eq("is_enable",0);
            return ResponseBean.success(partsStorageService.list(queryWrapper));
        }
    }

    @ApiModelProperty("通过零件名称搜索零件")
    @GetMapping("/getPartsStorageByPartsName/{partsName}")
    public ResponseBean getPartsStorageByPartsName(@PathVariable String partsName){
        List<PartsStorageVO> list =partsStorageService.getPartsStorageByPartsName(partsName);
        return ResponseBean.success(list);
    }
}
