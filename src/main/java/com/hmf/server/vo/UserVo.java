package com.hmf.server.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author humengfan
 * @since 2022年04月13日 16:19
 */
@Data
public class UserVo {
    private long id;
    private String realName;
    private String username;
    private String telephone;
    private String sex;
    private String position;
    private String idCard;
    private Date entryDate;
    private Boolean enable;
}
