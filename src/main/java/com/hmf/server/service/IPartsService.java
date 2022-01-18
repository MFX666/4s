package com.hmf.server.service;

import com.hmf.server.entity.Parts;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-16
 */
public interface IPartsService extends IService<Parts> {

    int insertParts(Parts parts);

    int updateParts(Parts parts);
}
