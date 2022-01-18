package com.hmf.server.entity.VO;

import com.hmf.server.entity.Company;
import com.hmf.server.entity.Parts;
import com.hmf.server.entity.PartsFactory;
import com.hmf.server.entity.PartsStorage;
import lombok.*;


@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PartsStorageVO extends PartsStorage {
    private Parts parts;
    private Company company;
    private PartsFactory partsFactory;
}
