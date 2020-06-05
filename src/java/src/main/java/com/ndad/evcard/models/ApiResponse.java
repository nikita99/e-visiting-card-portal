package com.ndad.evcard.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    String message;
    Boolean success;

    public static ApiResponse create(Object object, Boolean success) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return new ApiResponse(objectMapper.writeValueAsString(object), success);
    }
}
