package com.example.demo.service.role;

import com.example.demo.controller.role.request.CreateRoleRequest;
import com.example.demo.controller.role.request.UpdateRoleRequest;
import com.example.demo.controller.role.response.RoleResponse;

import java.util.List;

public interface RoleService {

       void create(CreateRoleRequest createRoleRequest);

       void update(UpdateRoleRequest updateRoleRequest);

       RoleResponse getById(int id);

       List<RoleResponse> getAll();

       void delete(int id);
}
