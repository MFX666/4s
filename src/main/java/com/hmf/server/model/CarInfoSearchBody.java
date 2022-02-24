package com.hmf.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarInfoSearchBody {
    private String carName; //车名
    private String carTag; //车标签
    private String carUpPrice;//最高价
    private String carLowPrice;//最低价
    private String brandName;//品牌名称
    private String brandLogoUrl;//品牌logo
    private Long[] brandId;//品牌id
}
