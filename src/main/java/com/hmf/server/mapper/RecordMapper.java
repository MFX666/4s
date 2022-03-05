package com.hmf.server.mapper;

import com.hmf.server.entity.Record;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hmf.server.model.SearchWxRecordBody;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author mfx
 * @since 2022-02-24
 */
public interface RecordMapper extends BaseMapper<Record> {

    List<Record> unionSearchWxRecord(SearchWxRecordBody searchWxRecordBody);

}
