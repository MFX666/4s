package com.hmf.server.service.impl;

import com.hmf.server.entity.PartsFactory;
import com.hmf.server.mapper.PartsFactoryMapper;
import com.hmf.server.service.IPartsFactoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
@Service
public class PartsFactoryServiceImpl extends ServiceImpl<PartsFactoryMapper, PartsFactory> implements IPartsFactoryService {

    @Autowired
    private PartsFactoryMapper partsFactoryMapper;
    @Override
    public int insertPartsFactory(PartsFactory partsFactory) {
        return partsFactoryMapper.insertPartsFactory(partsFactory);
    }

    @Override
    public int updatePartsFactory(PartsFactory partsFactory) {
        return partsFactoryMapper.update(partsFactory);
    }
}
