package com.hmf.server.entity.VO;


import com.hmf.server.entity.CarStorage;
import com.hmf.server.entity.Company;
import lombok.Data;

@Data
public class CarStorageVo extends CarStorage {
    private CarInfoVo carInfoVo;
    private Company company;

}
