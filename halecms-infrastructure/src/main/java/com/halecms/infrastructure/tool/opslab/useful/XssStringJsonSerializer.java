package com.halecms.infrastructure.tool.opslab.useful;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.halecms.infrastructure.tool.opslab.helper.WebHelper;

import java.io.IOException;

/**
 * Jackson反序列化防XSS
 */
public class XssStringJsonSerializer extends JsonSerializer<String> {
    @Override
    public Class<String> handledType() {
        return String.class;
    }
    @Override
    public void serialize(String value, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        if (value != null) {
            String encodedValue = WebHelper.replaceXSS(value);
            jsonGenerator.writeString(encodedValue);
        }
    }
}
