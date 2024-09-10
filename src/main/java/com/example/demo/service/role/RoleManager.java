package com.example.demo.service.role;

import com.example.demo.controller.role.request.CreateRoleRequest;
import com.example.demo.controller.role.request.UpdateRoleRequest;
import com.example.demo.controller.role.response.RoleResponse;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.role.Role;
import com.example.demo.repository.role.RoleRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleManager implements RoleService{

    private final RoleRepository roleRepository;
    private final ModelMapperService mapperService;

    @Override
    public void create(CreateRoleRequest createRoleRequest) {
        Role role = mapperService.forRequest().map(createRoleRequest, Role.class);
        roleRepository.save(role);
    }

    @Override
    public void update(UpdateRoleRequest updateRoleRequest) {
        roleRepository.findById(updateRoleRequest.getId())
                .orElseThrow(() -> new RuntimeException("Role not found:" + updateRoleRequest.getId() ));
        Role role =mapperService.forRequest().map(updateRoleRequest, Role.class);
        roleRepository.save(role);
    }

    @Override
    public RoleResponse getById(int id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found:" + id));
        return mapperService.forResponse().map(role, RoleResponse.class);
    }

    @Override
    public List<RoleResponse> getAll() {
        List<Role> roles = roleRepository.findAll();
        return roles.stream().map(role -> mapperService.forResponse().map(role, RoleResponse.class))
                .collect(Collectors.toList());

    }

    @Override
    public void delete(int id) {
        roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found:" + id));
        roleRepository.deleteById(id);

    }
}
