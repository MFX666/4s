package com.hmf.server.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarSaleInfoSearchBody {
    private long[] companyId;
    private String consumerName;

}
