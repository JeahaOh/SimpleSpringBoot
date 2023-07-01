package com.example.spring_study.mvc.config;

import com.example.spring_study.mvc.domain.type.CommonCodeLabelEnum;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeaha on 2023/06/30
 */
public class CommonCodeLabelEnumJsonSerializer extends JsonSerializer<CommonCodeLabelEnum> {
    @Override
    public void serialize(CommonCodeLabelEnum value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        Map<String, Object> map = new HashMap<>();
        map.put("code", value.code());
        map.put("label", value.label());
    
        jsonGenerator.writeObject(map);
    }
}
