package com.hmf.server.service.impl;

import com.hmf.server.entity.Company;
import com.hmf.server.entity.VO.CompanyVo;
import com.hmf.server.mapper.CompanyMapper;
import com.hmf.server.model.CompanySearchBody;
import com.hmf.server.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<CompanyVo> getAllCompanyInfo() {

        return companyMapper.getAllCompanyInfo();
    }

    @Override
    public int updateCompanyInfo(Company company) {
        company.setUpdatetime(LocalDateTime.now());
        return companyMapper.updateCompanyInfo(company);
    }

    @Override
    public int insertCompanyInfo(Company company) {
        company.setCreatetime(LocalDateTime.now());
        company.setUpdatetime(LocalDateTime.now());
        return companyMapper.insertCompanyInfo(company);
    }

    @Override
    public List<CompanyVo> unionSearchCompanyInfo(CompanySearchBody companySearchBody) {
        return  companyMapper.unionSearchCompanyInfo(companySearchBody);
    }
}
