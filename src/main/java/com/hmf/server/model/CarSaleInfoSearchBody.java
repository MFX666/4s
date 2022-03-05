package com.hmf.server.model;

import lombok.Builder;
import lombok.Data;

@Data
public class CarSaleInfoSearchBody {
    private long companyId;
    private String consumerName;
}
