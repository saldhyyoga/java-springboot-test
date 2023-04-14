package com.bni.test.dto.request;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UpdateUserRequestDTO {

    @Size(min = 16, message = "Length of ssn min 16 characters")
    private String ssn;

    @Size(min = 3, max = 100, message = "Length of first_name is minimum 3 and maximum characters")
    private String first_name;

    @Size(min = 3, max = 100 , message = "Length of first_name is minimum 3 and maximu 100 characters")
    private String last_name;

    private String birth_date;
}
