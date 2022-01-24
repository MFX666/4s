package com.hmf.server.service.impl;

import com.hmf.server.entity.PartsStorage;
import com.hmf.server.entity.VO.PartsStorageVO;
import com.hmf.server.mapper.PartsStorageMapper;
import com.hmf.server.model.PartsStorageSearchBody;
import com.hmf.server.service.IPartsStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
@Service
public class PartsStorageServiceImpl extends ServiceImpl<PartsStorageMapper, PartsStorage> implements IPartsStorageService {
    @Autowired
    private PartsStorageMapper partsStorageMapper;

    @Override
    public List<PartsStorageVO> searchParts(PartsStorageSearchBody partsStorageSearchBody) {
        return partsStorageMapper.searchParts(partsStorageSearchBody);
    }

    @Override
    public int insertPartsStorage(PartsStorage partsStorage) {
        return partsStorageMapper.insertPartsStorage(partsStorage);
    }

    @Override
    @Transactional
    public int updateEnableById(Long[] ids) {
        if (partsStorageMapper.updateEnableById(ids) == ids.length) {
            return ids.length;
        } else {
            int a = 1 / 0;
            return 0;
        }
    }
}
