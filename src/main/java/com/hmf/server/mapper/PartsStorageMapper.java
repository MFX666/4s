package com.hmf.server.mapper;

import com.hmf.server.entity.PartsStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.entity.VO.PartsStorageVO;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface PartsStorageMapper extends BaseMapper<PartsStorage> {

    List<PartsStorageVO> getPartsStorageByPartsName(String partsName);

    List<PartsStorageVO> getPartsStorageByCompanyId(Long companyId);
}
