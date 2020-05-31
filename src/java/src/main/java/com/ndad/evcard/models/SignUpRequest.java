package com.ndad.evcard.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class SignUpRequest {

    @NotBlank
    @Size(min = 2, max = 100)
    String username;

    @NotBlank
    @Email
    @Size(max = 100)
    String email;

    @NotBlank
    @Size(min = 6, max = 20)
    String password;

}
