package com.ndad.evcard.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    Object message;
    Boolean success;
}
