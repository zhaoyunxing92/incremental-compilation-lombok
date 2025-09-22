package com.incremental.bootstrap.wrapper;

import com.alibaba.fastjson2.JSON;
import com.incremental.bootstrap.annotations.ResponseBodyWrapperController;
import com.incremental.bootstrap.response.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author docker
 */
@RestControllerAdvice(annotations = ResponseBodyWrapperController.class)
public class ResponseBodyWrapper implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        // 如果返回的是String类型
        if (body instanceof String) {
            // 这里需要手动转换成JSON格式字符串
            return JSON.toJSONString(Response.getSuccessResult(body));
        }

        if (body instanceof Response t) {
            return t;
        }
        return Response.getSuccessResult(body);
    }
}