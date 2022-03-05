package com.hmf.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarStorageBody extends CarInfoSearchBody {
    private String companyName;
    private Long companyId;
    private int isEnable;
    private String companyAddress;
    private Long[] ids;
}
