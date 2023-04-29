package com.demo.model.request;

import com.demo.enumerated.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class UserRequest {

    private String name;

    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate birthDate;

    private String email;

    private Gender gender;
}
