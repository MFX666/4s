package com.hmf.server.entity.VO;

import com.hmf.server.entity.CarSaleInfo;

import lombok.Data;

import java.util.List;

@Data
public class CarSaleInfoVo extends CarSaleInfo {
    private String carName;//车辆名
    private String carPictureUrl;//车辆图片地址
    private String carPrice ;//车辆价格
    private String carTag;//车辆标签
    private String carParameterInfo;//车辆参数信息
    private String brandName;//品牌名称
    private String companyName;//公司id
}
