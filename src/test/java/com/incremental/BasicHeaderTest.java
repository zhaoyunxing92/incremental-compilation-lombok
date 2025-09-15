package com.incremental;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;


class BasicHeaderTest {

    @Test
    void getTable() {
        String json = "{\"table\":\"user\",\"bizId\":\"123456\"}";
        FastJsonConfig config = new FastJsonConfig();

        Type type = new TypeReference<BasicHeader>() {
        }.getType();

        //byte[] bytes = new byte() 123, 34, 99, 117, 114, 114, 101, 110, 116, 34, 58, 49, 44, 34, 112, 97, 103, 101, 83, 105, 122, 101, 34, 58, 51, 48, 44, 34, 102, 105, 101, 108, 100, 115, 34, 58, 91, 93, 44, 34, 112, 97, 103, 101, 34, 58, 49, 44, 34, 116, 121, 112, 101, 34, 58, 49, 125 ];

        byte[] bytes = json.getBytes(StandardCharsets.UTF_8);
        BasicHeader parsed = JSON.parseObject(bytes, type, config.getDateFormat(), config.getReaderFilters(), config.getReaderFeatures());

        System.out.println(parsed.getTable());
    }
}