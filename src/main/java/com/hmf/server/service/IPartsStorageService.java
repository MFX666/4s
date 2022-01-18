package com.hmf.server.service;

import com.hmf.server.entity.PartsStorage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.entity.VO.PartsStorageVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface IPartsStorageService extends IService<PartsStorage> {

    List<PartsStorageVO> getPartsStorageByPartsName (String partsName);

    List<PartsStorageVO> getPartsStorageByCompanyId(Long companyId);
}
