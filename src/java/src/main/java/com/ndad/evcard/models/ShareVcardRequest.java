package com.ndad.evcard.models;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Data
public class ShareVcardRequest {

    @NotBlank
    @Email
    String receiverEmail;

    @NotBlank
    UUID vcardId;

}
