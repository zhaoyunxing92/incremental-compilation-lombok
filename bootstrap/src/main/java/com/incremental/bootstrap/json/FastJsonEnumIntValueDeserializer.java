package com.incremental.bootstrap.json;

import com.alibaba.fastjson2.JSONReader;
import com.alibaba.fastjson2.reader.ObjectReader;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author docker
 */
@Slf4j
public class FastJsonEnumIntValueDeserializer implements ObjectReader<Object> {

    @Override
    public Object readObject(JSONReader reader, Type type, Object fieldName, long features) {
        Class<?> cls = (Class<?>) type;
        Object[] enumConstants = cls.getEnumConstants();

        if (EnumIntValue.class.isAssignableFrom(cls)) {
            if (reader.isInt()) {
                int intValue = reader.readInt32();
                for (Object enumConstant : enumConstants) {
                    if (((EnumIntValue) enumConstant).getValue() == intValue) {
                        return enumConstant;
                    }
                }
            }
        } else if (EnumStringValue.class.isAssignableFrom(cls)){
            if (reader.isString()) {
                String stringValue = reader.readString();
                for (Object enumConstant : enumConstants) {
                    if (Objects.equals(((EnumStringValue) enumConstant).getCode(), stringValue)) {
                        return enumConstant;
                    }
                }
            }
        } else {
            if (reader.isInt()) {
                int intValue = reader.readInt32();
                throw new IllegalArgumentException("parse enum " + cls.getName() + " error, value: " + intValue);
            } else if (reader.isString()) {
                String stringValue = reader.readString();
                return Enum.valueOf((Class<Enum>) cls, stringValue);
            }
        }
        return null;
    }


}

