package com.hmf.server.controller;


import com.hmf.server.entity.Company;
import com.hmf.server.entity.VO.CompanyVo;
import com.hmf.server.model.CompanySearchBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICompanyService;
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
 * @since 2022-01-15
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {
    @Autowired
    private ICompanyService iCompanyService;

    @ApiModelProperty("获取企业信息")
    @GetMapping("/getAllCompanyInfo")
    public ResponseBean getAllCompanyInfo(){
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
                return ResponseBean.error("更新失败");
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
               return ResponseBean.error("添加失败");
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
