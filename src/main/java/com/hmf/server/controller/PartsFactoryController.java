package com.hmf.server.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.PartsFactory;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IPartsFactoryService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
@RestController
@RequestMapping("/parts-factory")
public class PartsFactoryController extends BaseController {
    @Autowired
    private IPartsFactoryService iPartsFactoryService;

    @ApiModelProperty("获取所有零部件厂商的信息")
    @GetMapping("/getAllPartsFactoryInfo")
    public ResponseBean getAllPartsFactoryInfo() {
        return ResponseBean.success(iPartsFactoryService.list());
    }

    @ApiModelProperty("通过名字搜索厂家")
    @GetMapping("/getPartFactoryInfoByName/{factoryName}")
    public ResponseBean getPartFactoryInfoByName(@PathVariable String factoryName) {
        if (factoryName == null) {
            return ResponseBean.error("参数为空");
        } else {
            QueryWrapper<PartsFactory> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("factory_name", factoryName);
            return ResponseBean.success(iPartsFactoryService.list(queryWrapper));
        }
    }

    @ApiModelProperty("添加零部件厂商的信息")
    @PostMapping("/addPartsFactory")
    public ResponseBean addPartsFactory(@RequestBody PartsFactory partsFactory) {
        if (partsFactory == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (iPartsFactoryService.save(partsFactory)) {
                return ResponseBean.success("添加成功");
            } else {
                return ResponseBean.error("该零部件厂家已存在，请勿重复添加");
            }
        }
    }

    @ApiModelProperty("修改零部件厂商的信息")
    @PostMapping("/updatePartsFactory")
    public ResponseBean updatePartsFactory(@RequestBody PartsFactory partsFactory) {
        if (partsFactory == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (iPartsFactoryService.updatePartsFactory(partsFactory) > 0) {
                return ResponseBean.success("修改成功");
            } else {
                return ResponseBean.error("修改失败");
            }
        }
    }
//    @ApiOperation("删除零部件厂商的信息")
//    @DeleteMapping("deleteParts/{id}")
//    public ResponseBean deleteParts(@PathVariable Integer id){
//        if(id==null){
//            return ResponseBean.error("参数为空");
//        }else {
//
//        }
//    }

}
