package com.hmf.server.mapper;

import com.hmf.server.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.entity.VO.CompanyVo;
import com.hmf.server.model.CompanySearchBody;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
public interface CompanyMapper extends BaseMapper<Company> {

    List<CompanyVo> getAllCompanyInfo();

    int updateCompanyInfo(Company company);

    int insertCompanyInfo(Company company);

    List<CompanyVo> unionSearchCompanyInfo(CompanySearchBody companySearchBody);
}
