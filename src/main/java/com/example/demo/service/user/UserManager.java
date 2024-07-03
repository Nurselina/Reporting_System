package com.example.demo.service.user;

import com.example.demo.controller.user.request.CreateUserRequest;
import com.example.demo.controller.user.request.UpdateUserRequest;
import com.example.demo.controller.user.response.UserResponse;
import com.example.demo.core.mapper.ModelMapperService;
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

    @Override
    public void create(CreateUserRequest createUserRequest) {
        User user = modelMapperService.forRequest().map(createUserRequest, User.class);
        userRepository.save(user);
    }

    @Override
    public void update(UpdateUserRequest updateUserRequest) {
        userRepository.findById(updateUserRequest.getId())
                .orElseThrow(() ->new RuntimeException("User not found:" + updateUserRequest.getId() ));
        User user = modelMapperService.forRequest().map(updateUserRequest, User.class);
        userRepository.save(user);

    }

    @Override
    public UserResponse getById(int id) {
        User user = userRepository.findById(id)
                .orElseThrow(() ->new RuntimeException("User not found:" + id));
        return modelMapperService.forResponse().map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapperService.forResponse().map(user, UserResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(int id) {
        userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found:" + id));
        userRepository.deleteById(id);
    }
}
