package com.hmf.server.enums;

import lombok.Data;

/**
 * @author humengfan
 * @since 2022年04月13日 16:16
 */

public enum PositionEnums {
    ;
    private String code;
    private String label;



    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    PositionEnums(String code, String label) {
        this.code = code;
        this.label = label;
    }

}
