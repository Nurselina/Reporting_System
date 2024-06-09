package com.example.demo.controller.user.employee.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequest {

    @NotNull
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String  email;

    @NotBlank
    private String password;

    @NotBlank
    private String phone;

}
