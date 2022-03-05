package com.hmf.server.entity.VO;

import com.hmf.server.entity.CarSaleInfo;

import lombok.Data;

@Data

public class CarSaleInfoVo extends CarSaleInfo {
    private CarStorageVo carStorageVo;
}
