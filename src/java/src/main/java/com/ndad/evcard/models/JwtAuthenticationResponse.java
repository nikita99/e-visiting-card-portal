package com.ndad.evcard.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class JwtAuthenticationResponse {

    @NonNull
    String accessToken;

    String tokenType = "Bearer";

}
