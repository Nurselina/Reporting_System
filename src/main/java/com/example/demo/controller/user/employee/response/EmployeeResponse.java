package com.example.demo.controller.user.employee.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private String name;
    private String surname;
    private String  email;
    private String phone;
    private String roleName;
}
