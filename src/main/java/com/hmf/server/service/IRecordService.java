package com.hmf.server.service;

import com.hmf.server.entity.Record;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hmf.server.model.SearchWxRecordBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author mfx
 * @since 2022-02-24
 */
public interface IRecordService extends IService<Record> {

    List<Record> unionSearchWxRecord(SearchWxRecordBody searchWxRecordBody);
}
