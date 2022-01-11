package com.hmf.server.mapper;

import com.hmf.server.entity.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface CompanyMapper extends BaseMapper<Company> {

    Company getCompanyInfoById(Integer id);
}
