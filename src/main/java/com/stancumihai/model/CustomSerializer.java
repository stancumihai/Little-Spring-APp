package com.stancumihai.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CustomSerializer extends StdSerializer<String> {

    public CustomSerializer(){
        this(null);
    }
    public CustomSerializer(Class<String> t) {
        super(t);
    }

    @Override
    public void serialize(String id, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeObject(new ObjectMapper().readTree(id));
    }
}
