package com.bni.test.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UpdateUserSettingRequestDTO {

    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private String biometric_login;

    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private String push_notification;

    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private String sms_notification;

    @NotNull
    @Pattern(regexp = "^true$|^false$", message = "allowed input: true or false")
    private String show_onboarding;

    @NotNull
    private String widget_order;
}
