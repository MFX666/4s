package com.hmf.server.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author humengfan
 * @since 2022年04月30日 10:48
 */
@Data
public class ParametersInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String factory;
    private String level;
    private String theEngine;
    private String volume;
    private String structure;
    private String speed;
    private String warranty;
}
