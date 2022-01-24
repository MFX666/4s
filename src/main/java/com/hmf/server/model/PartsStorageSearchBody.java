package com.hmf.server.model;

import com.hmf.server.entity.VO.PartsStorageVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PartsStorageSearchBody {
    private Long companyId; //企业id
    private String partsNumber;
    private String partsName; //零部件名称
    private String partsTag; //零部件分类
    private String partsFactoryName; //厂商名称
    private Integer isEnable; //是否可以使用
    private String companyName; //企业名称

}
