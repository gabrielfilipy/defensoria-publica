package com.dp.integration;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.data.domain.Page;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

@JsonComponent
public class SerializadorJson extends JsonSerializer<Page<?>> {

	@Override
	public void serialize(Page<?> value, JsonGenerator gen, 
			SerializerProvider serializers) throws IOException {
		
		gen.writeStartObject(); 
				
		gen.writeObjectField("content", value.getContent());
		gen.writeNumberField("pageNumber", value.getNumber());
		gen.writeNumberField("pageSize", value.getSize());
		gen.writeNumberField("totalCount", value.getTotalElements());
				
		gen.writeEndObject();
	}
	
}
