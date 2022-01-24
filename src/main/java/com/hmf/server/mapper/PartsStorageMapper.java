package com.hmf.server.mapper;

import com.hmf.server.entity.PartsStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.entity.VO.PartsStorageVO;
import com.hmf.server.model.PartsStorageSearchBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface PartsStorageMapper extends BaseMapper<PartsStorage> {

    List<PartsStorageVO> searchParts(PartsStorageSearchBody partsStorageSearchBody);

    int insertPartsStorage(PartsStorage partsStorage);

    int updateEnableById(Long[] ids);
}
