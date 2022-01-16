package com.hmf.server.service.impl;

import com.hmf.server.entity.Parts;
import com.hmf.server.mapper.PartsMapper;
import com.hmf.server.service.IPartsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class PartsServiceImpl extends ServiceImpl<PartsMapper, Parts> implements IPartsService {

}
