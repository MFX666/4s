package com.hmf.server.entity.VO;

import com.hmf.server.entity.Brand;
import com.hmf.server.entity.Company;
import lombok.Data;

@Data
public class CompanyVo extends Company {
    private Brand brand;
}
