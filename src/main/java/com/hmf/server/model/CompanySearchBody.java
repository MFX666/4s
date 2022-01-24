package com.hmf.server.model;

import lombok.Data;

@Data
public class CompanySearchBody {
    private String companyName;
    private String companyId;
    private String companyAddress;
    private Long brandId;
    private String brandName;
}
