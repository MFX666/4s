package com.hmf.server.service.impl;

import com.hmf.server.entity.Company;
import com.hmf.server.mapper.CompanyMapper;
import com.hmf.server.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    @Override
    public Company getCompanyInfoById(Integer id) {
        return companyMapper.getCompanyInfoById(id);
    }
}
