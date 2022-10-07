package com.hmf.server.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.hmf.server.entity.Brand;
import com.hmf.server.entity.Company;
import com.hmf.server.entity.User;
import com.hmf.server.entity.VO.CompanyVo;
import com.hmf.server.model.CompanySearchBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IBrandService;
import com.hmf.server.service.ICompanyService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

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
@RequestMapping("/company")
public class CompanyController extends BaseController {
    @Autowired
    private ICompanyService iCompanyService;

    @Autowired
    private IBrandService brandService;

    @ApiModelProperty("获取企业信息")
    @GetMapping("/getAllCompanyInfo")
    public ResponseBean getAllCompanyInfo(){
        Long companyId = (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCompanyId());
        if (ObjectUtil.isNotEmpty(companyId)) {
            Company company = iCompanyService.getById(companyId);
            Brand brand = brandService.getById(company.getBrandId());
            CompanyVo companyVo = new CompanyVo();
            BeanUtils.copyProperties(company,companyVo);
            companyVo.setBrand(brand);
            return ResponseBean.success(CollectionUtil.toList(companyVo));
        }
        List<CompanyVo> list = iCompanyService.getAllCompanyInfo();
        return ResponseBean.success(list);
    }

    @ApiModelProperty("更新企业信息")
    @PostMapping("/updateCompanyInfo")
    public ResponseBean updateCompanyInfo(@RequestBody Company company){
        if (company == null) {
            return ResponseBean.error("参数为空");
        } else {
            if(iCompanyService.updateCompanyInfo(company)>0){
                return ResponseBean.success("更新成功");
            }else{
                return ResponseBean.error("企业已存在，请检查");
            }
        }
    }

    @ApiModelProperty("添加企业信息")
    @PostMapping("/insertCompanyInfo")
    public ResponseBean insertCompanyInf(@RequestBody Company company){
        if(company==null){
            return ResponseBean.error("参数为空");
        }else{
           if(iCompanyService.insertCompanyInfo(company)>0){
               return ResponseBean.success("添加成功");
           }else {
               return ResponseBean.error("企业已存在，请勿重复添加");
           }
        }
    }

    @ApiModelProperty("组合查询企业信息")
    @PostMapping("/unionSearchCompanyInfo")
    public ResponseBean unionSearchCompanyInfo(@RequestBody CompanySearchBody companySearchBody){
        if(companySearchBody==null){
            return ResponseBean.error("参数为空");
        }else{
            List<CompanyVo> list = iCompanyService.unionSearchCompanyInfo(companySearchBody);
            return ResponseBean.success(list);
        }
    }

}
