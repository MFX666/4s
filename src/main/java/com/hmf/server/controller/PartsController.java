package com.hmf.server.controller;


import com.hmf.server.entity.Parts;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IPartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.hmf.server.controller.BaseController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@RestController
@RequestMapping("/parts")
public class PartsController extends BaseController {
    @Autowired
    private IPartsService iPartsService;

    /**
     * @return
     * 查询所有零件
     * 后续添加分页功能
     */
    @GetMapping("/getAllPartsInfo")
    public ResponseBean getAllPartsInfo(){
        return ResponseBean.success(iPartsService.list());
    }


    /**
     * @param name
     * @return
     * 零件名称查询零件---使用模糊查询
     */
    @GetMapping("/getPartsInfoByName/{name}")
    public ResponseBean getPartsInfoByName (@PathVariable String name){
        if(name==null){
            return  ResponseBean.error("名称为空不能查询");
        }else {
            List<Parts> parts = iPartsService.getPartsInfoByName(name);
            if(parts!=null){
                return ResponseBean.success(parts);
            }else {
                return ResponseBean.error("未查询到相关零件");
            }
        }
    }
}
