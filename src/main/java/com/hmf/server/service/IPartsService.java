package com.hmf.server.service;

import com.hmf.server.entity.Parts;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-01-08
 */
public interface IPartsService extends IService<Parts> {

    List<Parts> getPartsInfoByName(String name);
}
