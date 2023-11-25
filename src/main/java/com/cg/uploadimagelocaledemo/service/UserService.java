package com.cg.uploadimagelocaledemo.service;

import com.cg.uploadimagelocaledemo.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UserService {
    public User create(String email, String password, MultipartFile image) throws IOException;
}
