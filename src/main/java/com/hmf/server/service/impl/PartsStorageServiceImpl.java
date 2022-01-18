package com.hmf.server.service.impl;

import com.hmf.server.entity.PartsStorage;
import com.hmf.server.entity.VO.PartsStorageVO;
import com.hmf.server.mapper.PartsStorageMapper;
import com.hmf.server.service.IPartsStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
@Service
public class PartsStorageServiceImpl extends ServiceImpl<PartsStorageMapper, PartsStorage> implements IPartsStorageService {
    @Autowired
    private PartsStorageMapper partsStorageMapper ;
    @Override
    public List<PartsStorageVO> getPartsStorageByPartsName(String partsName) {
        return partsStorageMapper.getPartsStorageByPartsName(partsName);

    }

    @Override
    public List<PartsStorageVO> getPartsStorageByCompanyId(Long companyId) {
        return partsStorageMapper.getPartsStorageByCompanyId(companyId);
    }
}
