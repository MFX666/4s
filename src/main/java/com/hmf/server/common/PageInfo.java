package com.hmf.server.common;

import lombok.Data;

import java.util.List;

/**
 * @author humengfan
 * @since 2022年04月08日 10:24
 */
@Data
public class PageInfo<T>{
    private long current;
    private long size;
    private long total;
    private List<T> record;
    private long pages;
}
