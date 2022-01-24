package com.hmf.server.entity.VO;

import com.hmf.server.entity.CarInfo;
import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.Company;
import jdk.nashorn.internal.ir.BreakableNode;
import lombok.Data;

@Data
public class CarStorageVo extends CarStorage {
    private CarInfoVo carInfoVo;
    private Company companyVo;
}
