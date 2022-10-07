package com.hmf.server.param;

import lombok.Data;

/**
 * @author humengfan
 * @since 2022年05月04日 18:32
 */
@Data
public class UpdatePasswordParam {
    private String oldOne;
    private String newOne;
}
