package com.hmf.server.controller;


import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hmf.server.entity.Company;
import com.hmf.server.entity.Remark;
import com.hmf.server.entity.User;
import com.hmf.server.entity.VO.RemarkVo;
import com.hmf.server.model.ResponseBean;
import com.hmf.server.param.RemarkParam;
import com.hmf.server.service.ICompanyService;
import com.hmf.server.service.IRemarkService;
import com.hmf.server.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.hmf.server.controller.BaseController;

import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/remark")
public class RemarkController extends BaseController {

    @Autowired
    private IRemarkService remarkService;
    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IUserService userService;
    @PostMapping("/save")
    public ResponseBean save(@RequestBody RemarkParam param) {
        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Remark remark = new Remark();
        remark.setId(new Snowflake().nextId());
        remark.setCompanyId(param.getCompanyId());
        remark.setContent(param.getContent());
        remark.setUserId(loginUser.getId());
        remark.setCreateTime(new Date());
        if (remarkService.save(remark)) {
            return ResponseBean.success("评论成功");
        } else {
            return ResponseBean.error("评论失败");
        }
    }

    @GetMapping("/get")
    public ResponseBean get (){
        User loginUser = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        List<RemarkVo> result = new ArrayList<>();
        if(ObjectUtil.isNotEmpty(loginUser.getCompanyId())){
            Company company = companyService.getById(loginUser.getCompanyId());
            String companyName = company.getCompanyName();
            List<Remark> list = remarkService.list(new LambdaQueryWrapper<Remark>().eq(Remark::getCompanyId, loginUser.getCompanyId()));
            if (CollectionUtil.isNotEmpty(list)) {
                list.forEach(one->{
                    RemarkVo vo = new RemarkVo();
                    BeanUtils.copyProperties(one,vo);
                    vo.setCompanyName(companyName);
                    User user = userService.getById(one.getUserId());
                    vo.setConsumerName(user.getRealName());
                    result.add(vo);
                });
            }

        }else{
            List<Remark> list = remarkService.list(new LambdaQueryWrapper<Remark>().eq(Remark::getUserId, loginUser.getId()));
            if (CollectionUtil.isNotEmpty(list)) {
                list.forEach(one->{
                    RemarkVo vo = new RemarkVo();
                    BeanUtils.copyProperties(one,vo);
                    Company company = companyService.getById(one.getCompanyId());
                    vo.setConsumerName(loginUser.getRealName());
                    vo.setCompanyName(company.getCompanyName());
                    result.add(vo);
                });
            }
        }
        return ResponseBean.success(result);
    }
}
