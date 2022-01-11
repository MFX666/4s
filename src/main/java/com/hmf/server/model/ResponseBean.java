package com.hmf.server.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 公共返回对象
 *
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
    private long code;
    private String message;
    private Object obj;

    public ResponseBean(long code , Object obj){
        this.code = code;
        this.obj= obj;
    }

    /*
     * 成功返回
     * */
    public static ResponseBean success(String message) {
        return new ResponseBean(200, message, null);
    }

    /*
     * 返回成功结果
     *
     * */
    public static ResponseBean success(String message, Object obj) {
        return new ResponseBean(200, message, obj);
    }
    public static ResponseBean success(Object obj) {
        return new ResponseBean(200, obj);
    }
    /*
     * 失败返回结果
     * */
    public static ResponseBean error(String message) {
        return new ResponseBean(500, message, null);
    }
    /*
    * 返回失败结果
    * */
    public static ResponseBean error(String message, Object obj) {
        return new ResponseBean(500, message, obj);
    }
}
