package com.hmf.server.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.PartsStorage;
import com.hmf.server.entity.User;
import com.hmf.server.entity.VO.PartsStorageVO;
import com.hmf.server.model.PartsStorageSearchBody;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IPartsStorageService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * <p>
 * 前端控制器
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

    /**
     * @param partsStorageSearchBody Long companyId; //企业id
     *                               String parts_number;
     *                               String partsName; //零部件名称
     *                               String partsTag; //零部件分类
     *                               String partsFactoryName; //厂商名称
     *                               Integer isEnable; //是否可以使用
     * @return
     */
    @ApiModelProperty("零部件库存信息组合查询")
    @PostMapping("/searchParts")
    public ResponseBean searchParts(@RequestBody PartsStorageSearchBody partsStorageSearchBody) {
        Long companyId = (((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getCompanyId());
        if (companyId != null) {
            return ResponseBean.success(partsStorageService.list(new LambdaQueryWrapper<PartsStorage>().eq(PartsStorage::getCompanyId, companyId)));
        } else {
            if (partsStorageSearchBody == null) {
                return ResponseBean.error("参数为空");
            } else {
                LambdaQueryWrapper<PartsStorage> wrapper = new LambdaQueryWrapper<>();
                if(ObjectUtil.isNotEmpty(partsStorageSearchBody.getCompanyId())){
                    wrapper.eq(PartsStorage::getCompanyId,partsStorageSearchBody.getCompanyId());
                }
                if(ObjectUtil.isNotEmpty(partsStorageSearchBody.getPartsNumber())){
                    wrapper.like(PartsStorage::getPartsNumber,partsStorageSearchBody.getPartsNumber());
                }
                if(ObjectUtil.isNotEmpty(partsStorageSearchBody.getPartsName())){
                    wrapper.like(PartsStorage::getPartsName,partsStorageSearchBody.getPartsName());
                }
                if(ObjectUtil.isNotEmpty(partsStorageSearchBody.getPartsFactoryName())){
                    wrapper.like(PartsStorage::getFactoryName,partsStorageSearchBody.getPartsFactoryName());
                }
                if(ObjectUtil.isNotEmpty(partsStorageSearchBody.getCompanyName())){
                    wrapper.like(PartsStorage::getCompanyName,partsStorageSearchBody.getCompanyName());
                }
                List<PartsStorage> list = partsStorageService.list(wrapper);
//                List<PartsStorageVO> list = partsStorageService.searchParts(partsStorageSearchBody);
                return ResponseBean.success(list);
            }
        }
    }


    /*
     * 公司入库零部件编号去重
     * */
    @ApiModelProperty("零部件入库")
    @PostMapping("/companyInsertPartsStorage")
    public ResponseBean companyInsertPartsStorage(@RequestBody PartsStorage partsStorage) {
        if (partsStorage == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (partsStorageService.insertPartsStorage(partsStorage) > 0) {
                return ResponseBean.success("入库成功");
            } else {
                return ResponseBean.error("该零件编号已存在，入库失败");
            }
        }
    }

    /*
     * 公司零部件出库
     *
     * */
    @ApiModelProperty("零部件出库")
    @PostMapping("/companyPartsStorageOut")
    public ResponseBean companyPartsStorageOut(Long[] ids) {
        if (ids == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (partsStorageService.updateEnableById(ids) == ids.length) {
                return ResponseBean.success("零件出库成功");
            } else {
                return ResponseBean.error("零件出库失败");
            }
        }
    }
}
