package com.cg.uploadimagelocaledemo.service;

import com.cg.uploadimagelocaledemo.model.User;
import com.cg.uploadimagelocaledemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImpl implements UserService {
    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private UserRepository userRepository;

    /**
     * Creates a new user with the given email, password, and image.
     *
     * @param  email     the email of the user
     * @param  password  the password of the user
     * @param  image     the image file of the user
     * @return           the created user
     * @throws IOException if there is an error in file handling
     */
    @Override
    public User create(String email, String password, MultipartFile image) throws IOException {
        Path srcPath = Paths.get("src\\main\\resources\\static");
        Path imagePath = Paths.get("images");
        Path resourcesFolderPath = CURRENT_FOLDER.resolve(srcPath).resolve(imagePath);
        if (!Files.exists(resourcesFolderPath)) {
            Files.createDirectories(resourcesFolderPath);
        }
        Path file = resourcesFolderPath.resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setPhoto(imagePath.resolve(image.getOriginalFilename()).toString());
        return userRepository.save(user);
    }
}
