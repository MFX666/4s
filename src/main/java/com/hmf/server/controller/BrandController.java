package com.hmf.server.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.Brand;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IBrandService;
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
@RequestMapping("/brand")
public class BrandController extends BaseController {
    @Autowired
    private IBrandService iBrandService;

    @GetMapping("/getAllBrands")
    public ResponseBean getAllBrands() {
        return ResponseBean.success("获取成功",iBrandService.list());
    }

    @PostMapping("/addBrand")
    public ResponseBean addBrand(@RequestBody Brand brand){
        if(brand==null){
            return ResponseBean.error("参数为空！");
        }else{
            //获取数据库中的品牌信息
            QueryWrapper <Brand> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("company_name",brand.getBrandName());
            Brand DBBrand = iBrandService.getOne(queryWrapper);
            if(brand.getBrandName().equals(DBBrand.getBrandName())){
                return ResponseBean.error("该品牌已存在，请勿重复添加");
            }else{
                if(iBrandService.save(brand)){
                    return ResponseBean.success("添加成功");
                }
            }
        }
        return ResponseBean.error("添加失败");
    }

}
