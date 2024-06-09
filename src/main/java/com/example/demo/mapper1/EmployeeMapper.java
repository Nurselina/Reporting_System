package com.example.demo.mapper1;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.repository.user.employee.Employee;

public class EmployeeMapper {

    public static Employee toEntity (CreateEmployeeRequest request){
        if(request == null){
            return null;
        }

        return Employee.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .phone(request.getPhone())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }

    public static EmployeeResponse toResponse (Employee employee){
        if(employee == null){
            return null;
        }

        return EmployeeResponse.builder()
                .name(employee.getName())
                .surname(employee.getSurname())
                .phone(employee.getPhone())
                .email(employee.getEmail())
                .build();
    }


}
