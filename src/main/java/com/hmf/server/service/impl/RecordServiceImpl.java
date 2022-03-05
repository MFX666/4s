package com.hmf.server.service.impl;

import com.hmf.server.entity.Record;
import com.hmf.server.mapper.RecordMapper;
import com.hmf.server.model.SearchWxRecordBody;
import com.hmf.server.service.IRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author mfx
 * @since 2022-02-24
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements IRecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Override
    public List<Record> unionSearchWxRecord(SearchWxRecordBody searchWxRecordBody) {
        return recordMapper.unionSearchWxRecord(searchWxRecordBody);
    }
}
