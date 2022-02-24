package com.hmf.server.entity.VO;

import com.hmf.server.entity.Brand;
import com.hmf.server.entity.CarInfo;
import lombok.Data;

@Data
public class CarInfoVo extends CarInfo {
    private Brand brand;
}
