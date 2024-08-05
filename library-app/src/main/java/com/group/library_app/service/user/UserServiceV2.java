package com.group.library_app.service.user;

import com.group.library_app.domain.user.User;
import com.group.library_app.domain.user.UserRepository;
import com.group.library_app.dto.user.request.UserCreateRequest;
import com.group.library_app.dto.user.request.UserUpdateRequest;
import com.group.library_app.dto.user.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {

    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(UserCreateRequest request) {
       User u = userRepository.save(new User(request.getName(), request.getAge()));
    }

    public List<UserResponse> getUsers(){
       List<User> users = userRepository.findAll();
       return users.stream().map(user -> new UserResponse(
               user.getId(),user.getName(),user.getAge())).collect(Collectors.toList());
    }
    public void updateUser(UserUpdateRequest request) {
        User user = userRepository.findById(request.getId()).
                orElseThrow(IllegalArgumentException::new);

        user.updateName(request.getName());
        userRepository.save(user);

    }

    public void deleteUser(String name) {
        User user = userRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("유저가 없음"));
        userRepository.delete(user);
    }

}
