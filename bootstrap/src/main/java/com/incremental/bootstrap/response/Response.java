package com.incremental.bootstrap.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author docker
 */
@Getter
@Setter
public class Response<T> {

    private T data;

    private boolean success;

    private String errorCode;

    private String errorMsg;

    public static <T> Response<T> getSuccessResult(T body) {
        Response<T> result = new Response<>();
        result.setSuccess(true);
        result.setData(body);
        return result;
    }
}
