package com.hmf.server.controller;


import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hmf.server.entity.Parts;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.service.IPartsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
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
@Api("零件常量管理")
@RequestMapping("/parts")
public class PartsController extends BaseController {
    @Autowired
    private IPartsService iPartsService;

    @ApiOperation("获取所有零件常量")
    @GetMapping("/getAllParts")
    public ResponseBean getAllParts() {
        return ResponseBean.success(iPartsService.list());
    }

    @ApiOperation("添加零件常量")
    @PostMapping("addParts")
    public ResponseBean addParts(@RequestBody Parts parts) {
        if (parts == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (iPartsService.insertParts(parts) > 0){
                return ResponseBean.success("添加成功");
            }else{
                return ResponseBean.error("该零件常量已存在，请勿重复添加");
            }

        }
    }

    @ApiOperation("通过标签查看零件常量")
    @GetMapping("/getPartsByTag/{tag}")
    public ResponseBean getPartsByTag(@PathVariable String tag) {
        if (tag == null) {
            return ResponseBean.error("参数为空");
        } else {
            QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("parts_tag", tag);
            List<Parts> list = iPartsService.list(queryWrapper);
            return ResponseBean.success(list);
        }
    }

    @ApiOperation("更新零件常量")
    @PostMapping("/updateParts")
    public ResponseBean updateParts(@RequestBody Parts parts) {
        if (parts == null) {
            return ResponseBean.error("参数为空");
        } else {
            if(iPartsService.updateParts(parts)>0){
                return ResponseBean.success("更新成功");
            }else{
                return ResponseBean.error("该零件常量已存在");
            }
        }
    }

    @ApiOperation("删除零件常量")
    @DeleteMapping("deleteParts/{id}")
    public ResponseBean deleteParts(@PathVariable Integer id) {
        if (id == null) {
            return ResponseBean.error("参数为空");
        } else {
            if (iPartsService.removeById(id)) {
                return ResponseBean.success("删除成功");
            } else {
                return ResponseBean.error("删除失败");
            }
        }
    }

    @ApiOperation("通过名字查找零件常量")
    @GetMapping("/getPartsByName/{name}")
    public ResponseBean getPartsByName(@PathVariable String name) {
        if (name == null) {
            return ResponseBean.error("参数为空");
        } else {
            QueryWrapper<Parts> queryWrapper = new QueryWrapper<>();
            queryWrapper.like("parts_name", name);
            List<Parts> list = iPartsService.list(queryWrapper);
            return ResponseBean.success(list);
        }
    }
}
