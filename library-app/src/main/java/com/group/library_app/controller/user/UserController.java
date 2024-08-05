package com.group.library_app.controller.user;

import com.group.library_app.dto.user.request.UserCreateRequest;
import com.group.library_app.dto.user.request.UserUpdateRequest;
import com.group.library_app.dto.user.response.UserResponse;
import com.group.library_app.service.user.UserServiceV1;
import com.group.library_app.service.user.UserServiceV2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserServiceV2 userService;


    public UserController(UserServiceV2 userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.save(request);
    }


    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }
    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){
        userService.deleteUser(name);

    }

}
