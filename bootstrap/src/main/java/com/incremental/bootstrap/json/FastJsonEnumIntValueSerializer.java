package com.incremental.bootstrap.json;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.writer.ObjectWriter;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

/**
 * @author docker
 */
@Slf4j
public class FastJsonEnumIntValueSerializer implements ObjectWriter<Object> {

    @Override
    public void write(JSONWriter writer, Object object, Object fieldName, Type fieldType, long features) {
        if (object instanceof EnumIntValue) {
            int value = ((EnumIntValue) object).getValue();
            writer.writeInt32(value);
        } else if (object instanceof EnumStringValue) {
            String code = ((EnumStringValue) object).getCode();
            writer.writeString(code);
        } else if (object instanceof Enum) {
            String name = ((Enum<?>) object).name();
            writer.writeString(name);
        } else {
            throw new IllegalArgumentException("Object is not a valid enum: " + object);
        }
    }
}