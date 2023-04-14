package com.bni.test.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateUserDto {

    @NotBlank(message = "ssn is mandatory")
    @Size(min = 16, message = "Length of ssn min 16 characters")
    private String ssn;

    @NotBlank(message = "first_name is mandatory")
    @Size(min = 3, message = "Length of first_name is minimum 3 characters")
    private String first_name;

    @Size(min = 3, message = "Length of middle_name minimum 3 characters")
    private String middle_name;

    @NotBlank(message = "birth_date is mandatory")
    private String birth_date;
}
