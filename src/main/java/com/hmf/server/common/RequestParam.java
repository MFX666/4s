package com.hmf.server.common;

import lombok.Data;

/**
 * @author humengfan
 * @since 2022年04月13日 16:41
 */
@Data
public class RequestParam<T> {
    private long size;
    private long current;
    private T param;
}
