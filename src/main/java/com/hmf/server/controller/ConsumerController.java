package com.hmf.server.controller;


import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hmf.server.entity.Consumer;
import com.hmf.server.entity.User;
import com.hmf.server.entity.VO.ConsumerVo;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.param.ConsumerParam;
import com.hmf.server.service.IConsumerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author mfx
 * @since 2022-05-04
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController extends BaseController {

    @Autowired
    private IConsumerService consumerService;

    @PostMapping("/save")
    public ResponseBean save(@RequestBody ConsumerParam param) {
        Consumer one = consumerService.getOne(new LambdaQueryWrapper<Consumer>().eq(Consumer::getConsumerTelephone, param.getConsumerTelephone()));
        if (ObjectUtil.isNotEmpty(one)) {
            return ResponseBean.error("已有客户请勿重复添加");
        }
        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(param, consumer);
        consumer.setCompanyId(loginUser.getCompanyId());
        if (consumerService.save(consumer)) {
            return ResponseBean.success("添加客户成功");
        }
        return ResponseBean.error("添加失败");
    }

    @GetMapping("/get")
    public ResponseBean get() {
        List<ConsumerVo> result = new ArrayList<>();
        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        List<Consumer> list = consumerService.list(new LambdaQueryWrapper<Consumer>().eq(Consumer::getCompanyId, loginUser.getCompanyId()));
        return ResponseBean.success(list);
    }

    @GetMapping("/delete/{id}")
    public ResponseBean delete(@PathVariable ("id") Long id){
        if (consumerService.removeById(id)) {
            return ResponseBean.success("删除成功");
        }
        return ResponseBean.error("删除失败");
    }
}
