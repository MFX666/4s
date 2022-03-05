package com.hmf.server.controller;


import com.hmf.server.entity.Record;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.model.SearchWxRecordBody;
import com.hmf.server.service.IRecordService;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-02-24
 */
@RestController
@RequestMapping("/record")
public class RecordController extends BaseController {
    @Autowired
    private IRecordService iRecordService;
    //查看维修记录
    //修改维修记录
    //添加维修记录
    //撤销维修记录
    @ApiModelProperty("查询所有维修记录")
    @GetMapping("/getWxRecord")
    public ResponseBean getWxRecord(){
        return ResponseBean.success(iRecordService.list());
    }
    @ApiModelProperty("添加维修记录")
    @PostMapping("/addWxRecord")
    public ResponseBean addWxRecord(@RequestBody Record record){
        if(record==null) return  ResponseBean.error("参数为空");
        record.setCreatetime(LocalDateTime.now());
        record.setUpdatetime(LocalDateTime.now());
        if(iRecordService.save(record)) return ResponseBean.success("维修记录添加成功");
        return ResponseBean.error("维修记录添加失败");
    }

    @ApiModelProperty("修改维修记录")
    @PostMapping("/updateRecord")
    public ResponseBean updateRecord(@RequestBody Record record){
        if(record==null) return  ResponseBean.error("参数为空");
        record.setUpdatetime(LocalDateTime.now());
        if(iRecordService.updateById(record)) return ResponseBean.success("维修记录修改成功");
        return ResponseBean.error("维修记录修改失败");
    }

    /**
     * @param searchWxRecordBody
     * 车牌号
     * 联系电话
     * 车主姓名
     * @return
     */
    @ApiModelProperty("查询维修记录")
    @PostMapping("/unionSearchWxRecord")
    public ResponseBean unionSearchWxRecord(@RequestBody SearchWxRecordBody searchWxRecordBody){
        if(searchWxRecordBody==null) return ResponseBean.error("参数为空");
        List<Record> records = iRecordService.unionSearchWxRecord(searchWxRecordBody);
        if(records!=null) return ResponseBean.success(records);
        return ResponseBean.error("根据具条件未查询到相关的维修记录");
    }
    @ApiModelProperty("删除未结算的维修记录")
    @DeleteMapping("/deleteWxRecord/{id}")
    public ResponseBean deleteWxRecord(@PathVariable Integer id){
        if(id==null) return ResponseBean.error("参数为空");
        Record targetRecord = iRecordService.getById(id);
        if(targetRecord==null) return ResponseBean.error("不存在该维修记录");
        if(targetRecord.getIsSettlement().equals("已结算")) return ResponseBean.error("已结算的维修记录不可删除");
        if(iRecordService.removeById(id)) return ResponseBean.success("删除成功");
        return ResponseBean.error("删除失败");
    }
}
