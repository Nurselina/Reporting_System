package com.example.demo.controller.role;

import com.example.demo.controller.BaseController;
import com.example.demo.controller.role.request.CreateRoleRequest;
import com.example.demo.controller.role.request.UpdateRoleRequest;
import com.example.demo.controller.role.response.RoleResponse;
import com.example.demo.service.role.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/roles")
public class RoleController extends BaseController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Void> createRole(@RequestBody @Valid CreateRoleRequest createRoleRequest){
        roleService.create(createRoleRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> updateRole(@RequestBody @Valid UpdateRoleRequest updateRoleRequest){
        roleService.update(updateRoleRequest);
        return answer(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getByIdRole(@PathVariable int id){
        return answer(roleService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAllRoles(){
        return answer(roleService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable int id){
        roleService.delete(id);
        return answer(HttpStatus.NO_CONTENT);
    }


}
