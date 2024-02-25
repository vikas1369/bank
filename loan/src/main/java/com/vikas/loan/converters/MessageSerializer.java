package com.vikas.loan.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vikas.loan.model.Message;
import org.apache.commons.lang3.SerializationException;
import org.apache.kafka.common.serialization.Serializer;


//set use-native-decoding: true to use custom message serialize in spring cloud stream binding
public class MessageSerializer implements Serializer<Message> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String topic, Message data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }

    }
}