package com.hmf.server.controller;


import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hmf.server.entity.Company;
import com.hmf.server.entity.Record;
import com.hmf.server.entity.User;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.model.SearchWxRecordBody;
import com.hmf.server.param.RecordParam;
import com.hmf.server.service.ICompanyService;
import com.hmf.server.service.IRecordService;
import io.swagger.annotations.ApiModelProperty;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.LongSummaryStatistics;

/**
 * <p>
 * 前端控制器
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

    @Autowired
    private ICompanyService companyService;

    //查看维修记录
    //修改维修记录
    //添加维修记录
    //撤销维修记录
    @ApiModelProperty("查询所有维修记录")
    @GetMapping("/getWxRecord")
    public ResponseBean getWxRecord() {

        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Long companyId = user.getCompanyId();
        if (ObjectUtil.isNotEmpty(companyId)) {
            //企业查询
            List<Record> list = iRecordService.list(new LambdaQueryWrapper<Record>().eq(Record::getCompanyId, companyId));
            return ResponseBean.success(list);
        } else {
            //用户查询
            List<Record> list = iRecordService.list(new LambdaQueryWrapper<Record>().eq(Record::getCustomerTelephone, user.getTelephone()));
            return ResponseBean.success(list);
        }
    }

    @ApiModelProperty("添加维修记录")
    @PostMapping("/addWxRecord")
    public ResponseBean addWxRecord(@RequestBody RecordParam param) {
        if (param == null) {
            return ResponseBean.error("参数为空");
        }
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Record record = new Record();
        BeanUtils.copyProperties(param, record);

        record.setCreatetime(new Date());
        record.setUpdatetime(new Date());
        record.setIsSettlement("未结算");
        record.setCompanyId(user.getCompanyId());
        Company company = companyService.getById(user.getCompanyId());
        record.setCompanyName(company.getCompanyName());
        record.setId(new Snowflake().nextId());
        if (iRecordService.save(record)) {
            return ResponseBean.success("维修记录添加成功");
        }
        return ResponseBean.error("维修记录添加失败");
    }

    @ApiModelProperty("修改维修记录")
    @PostMapping("/updateRecord")
    public ResponseBean updateRecord(@RequestBody Record record) {
        if (record == null) return ResponseBean.error("参数为空");
        record.setUpdatetime(new Date());
        if (iRecordService.updateById(record)) return ResponseBean.success("维修记录修改成功");
        return ResponseBean.error("维修记录修改失败");
    }

    /**
     * @param searchWxRecordBody 车牌号
     *                           联系电话
     *                           车主姓名
     * @return
     */
    @ApiModelProperty("查询维修记录")
    @PostMapping("/unionSearchWxRecord")
    public ResponseBean unionSearchWxRecord(@RequestBody SearchWxRecordBody searchWxRecordBody) {
        if (searchWxRecordBody == null) {
            return ResponseBean.error("参数为空");
        }
        List<Record> records = iRecordService.unionSearchWxRecord(searchWxRecordBody);
        return ResponseBean.success(records);

    }

    @ApiModelProperty("删除未结算的维修记录")
    @DeleteMapping("/deleteWxRecord/{id}")
    public ResponseBean deleteWxRecord(@PathVariable Integer id) {
        if (id == null) return ResponseBean.error("参数为空");
        Record targetRecord = iRecordService.getById(id);
        if (targetRecord == null) return ResponseBean.error("不存在该维修记录");
        if (targetRecord.getIsSettlement().equals("已结算")) return ResponseBean.error("已结算的维修记录不可删除");
        if (iRecordService.removeById(id)) return ResponseBean.success("删除成功");
        return ResponseBean.error("删除失败");
    }

    @GetMapping("/pay/{id}")
    public ResponseBean pay (@PathVariable("id") Long id){
        Record record = iRecordService.getById(id);
        String isSettlement = record.getIsSettlement();
        if("已结算".equals(isSettlement)){
            return ResponseBean.error("该订单已结算");
        }else{
            record.setIsSettlement("已结算");
        }
        if(iRecordService.updateById(record)){
            return ResponseBean.success("结算成功");
        }
        return ResponseBean.error("结算失败");
    }
}
