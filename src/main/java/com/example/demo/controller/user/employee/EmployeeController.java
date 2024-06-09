package com.example.demo.controller.user.employee;


import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.request.UpdateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.service.user.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public void createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        employeeService.create(createEmployeeRequest);
    }

    @PutMapping
    public void updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        employeeService.update(updateEmployeeRequest);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getByIdEmployee(@PathVariable int id){
        return employeeService.getById(id);
    }

    @GetMapping
    public List<EmployeeResponse> getAllEmployees(){
        return employeeService.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.delete(id);
    }


}
