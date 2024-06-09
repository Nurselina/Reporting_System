package com.example.demo.service.user.employee;

import com.example.demo.controller.user.employee.request.CreateEmployeeRequest;
import com.example.demo.controller.user.employee.request.UpdateEmployeeRequest;
import com.example.demo.controller.user.employee.response.EmployeeResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.user.employee.Employee;
import com.example.demo.repository.user.employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeManager implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public void create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
        employeeRepository.save(employee);
    }

    @Override
    public void update(UpdateEmployeeRequest updateEmployeeRequest) {
        employeeRepository.findById(updateEmployeeRequest.getId()).orElseThrow(() ->
                new RuntimeException("Employee not found: " + updateEmployeeRequest.getId()));
        Employee employee = modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
        employeeRepository.save(employee);

    }

    @Override
    public EmployeeResponse getById(int id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Employee not found: " + id));
        return modelMapperService.forResponse().map(employee, EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> getAll() {
        List<Employee> employeeList = employeeRepository.findAll();

        return employeeList.stream().map(employee -> modelMapperService.forResponse().map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        employeeRepository.findById(id).orElseThrow(() -> new RuntimeException(("Employee not found:" + id)));
        employeeRepository. deleteById(id);
    }
}
