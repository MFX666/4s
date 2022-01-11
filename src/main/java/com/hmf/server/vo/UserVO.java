package com.hmf.server.vo;

import com.hmf.server.entity.Company;
import com.hmf.server.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserVO extends User {
    private Company company;

}
