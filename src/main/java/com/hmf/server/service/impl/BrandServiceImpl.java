package com.hmf.server.service.impl;

import com.hmf.server.entity.Brand;
import com.hmf.server.mapper.BrandMapper;
import com.hmf.server.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-01-15
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public int insertBrandInfo(Brand brand) {
        return brandMapper.insertBrandInfo(brand);
    }
}
