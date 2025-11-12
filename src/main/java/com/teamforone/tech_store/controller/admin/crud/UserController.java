package com.teamforone.tech_store.controller.admin.crud;

import com.teamforone.tech_store.dto.request.UserRequest;
import com.teamforone.tech_store.dto.response.Response;
import com.teamforone.tech_store.model.User;
import com.teamforone.tech_store.service.admin.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // READ - Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }


    // READ - Get user by id
    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable String id) {
        return userService.getUserById(id);
    }

    // CREATE - Create new user

    @PostMapping("/users/add")
    public ResponseEntity<Response> createUser(@RequestBody UserRequest request) {
        Response response = userService.createUser(request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }


// UPDATE - Partial update user (chỉ update field được gửi lên)
    @PatchMapping("/users/update/{id}")
    public ResponseEntity<Response> updateUser(@PathVariable String id, @RequestBody UserRequest request) {
        Response response = userService.updateUser(id, request);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    // DELETE - Delete user by id
    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<Response> deleteUser(@PathVariable String id) {
        Response response = userService.deleteUser(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
