package com.example.demo.service.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.core.exception.NotFoundException;
import com.example.demo.core.exception.type.NotFoundExceptionType;
import com.example.demo.core.mapper.ModelMapperService;
import com.example.demo.repository.role.Role;
import com.example.demo.repository.role.RoleRepository;
import com.example.demo.repository.user.User;
import com.example.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManager implements UserService{

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;
    private final RoleRepository roleRepository;

    @Override
    public void create(CreateUserRequest createUserRequest) {

        Role role = roleRepository.findById(createUserRequest.getRoleId())
                .orElseThrow(() -> new NotFoundException(NotFoundExceptionType.ROLE_DATA_NOT_FOUND));

        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        user.setRole(role);
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() ->new NotFoundException(NotFoundExceptionType.USER_DATA_NOT_FOUND ));

        Role role = roleRepository.findById(updateUserRequest.getRoleId())
                .orElseThrow(() -> new NotFoundException(NotFoundExceptionType.ROLE_DATA_NOT_FOUND));

        User user = modelMapperService.forRequest().map(updateUserRequest, User.class);
        user.setRole(role);
        userRepository.save(user);

    }

    @Override
    public UserResponse getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->new NotFoundException(NotFoundExceptionType.USER_DATA_NOT_FOUND ));
        return modelMapperService.forResponse().map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        if (users.isEmpty()){
            throw new NotFoundException(NotFoundExceptionType.USER_LIST_NOT_FOUND);
        }
        return users.stream().map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        userRepository.findById(id).orElseThrow(() -> new NotFoundException(NotFoundExceptionType.USER_DATA_NOT_FOUND ));
        userRepository.deleteById(id);
    }
}
