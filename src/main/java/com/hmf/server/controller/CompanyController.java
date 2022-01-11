package com.hmf.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.Company;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/company")
public class CompanyController extends BaseController {

    @Autowired
    private ICompanyService iCompanyService;

    @GetMapping("/getCompanyInfo/{id}")
    public ResponseBean getCompanyInfo(@PathVariable Integer id){
        if(id==null){
            return ResponseBean.error("公司id为空，为找到该店铺");
        }else{
            Company company = iCompanyService.getCompanyInfoById(id);
            System.out.println(company.toString());
            if(company==null){
                return ResponseBean.error("未找到该店铺");
            }else{
                return ResponseBean.success("查询成功",company);
            }
        }
    }

    @PostMapping("/updateCompanyInfo")
    public ResponseBean updateCompanyInfo(@RequestBody Company company){
        if(company==null){
            return ResponseBean.error("修改失败");
        }else{
            company.setUpdatetime(LocalDateTime.now());
            if(iCompanyService.updateById(company)){
                return  ResponseBean.success("修改成功",company);
            }else{
                return ResponseBean.error("修改失败");
            }
        }
    }
}
