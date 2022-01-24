package com.hmf.server.service;

import com.hmf.server.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.entity.VO.CompanyVo;
import com.hmf.server.model.CompanySearchBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
public interface ICompanyService extends IService<Company> {

    List<CompanyVo> getAllCompanyInfo();

    int updateCompanyInfo(Company company);

    int insertCompanyInfo(Company company);

    List<CompanyVo> unionSearchCompanyInfo(CompanySearchBody companySearchBody);
}
