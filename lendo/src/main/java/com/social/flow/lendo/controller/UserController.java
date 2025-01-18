package com.social.flow.lendo.controller;

import com.social.flow.lendo.dto.User;
import com.social.flow.lendo.exception.NoDataFoundException;
import com.social.flow.lendo.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    @NonNull
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers( @RequestParam("page")  final int page,
                                                @RequestParam("per_page") final int perPage) {
        List<User> users = userService.getAllUsers(page,perPage);
        if (users.isEmpty()) {
            throw new NoDataFoundException("No users found");
        }
        return ResponseEntity.ok(users);
    }
}
