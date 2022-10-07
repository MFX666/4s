package com.hmf.server.entity.VO;

public class ParameterVo {
    private String parameterName;
    private String parameterValue;

    public ParameterVo(String parameterName, String parameterValue) {
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public ParameterVo() {
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }

    @Override
    public String toString() {
        return "ParameterVo{" +
                "parameterName='" + parameterName + '\'' +
                ", parameterValue='" + parameterValue + '\'' +
                '}';
    }
}
