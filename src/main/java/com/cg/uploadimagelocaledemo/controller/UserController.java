package com.cg.uploadimagelocaledemo.controller;

import com.cg.uploadimagelocaledemo.model.User;
import com.cg.uploadimagelocaledemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> create(@RequestParam String email,
                                 @RequestParam String password,
                                 @RequestParam MultipartFile image) throws IOException {
        return new ResponseEntity<>(userService.create(email, password, image), HttpStatus.CREATED);
    }
}
