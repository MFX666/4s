package com.hmf.server.service;

import com.hmf.server.entity.Company;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface ICompanyService extends IService<Company> {

    Company getCompanyInfoById(Integer id);
}
