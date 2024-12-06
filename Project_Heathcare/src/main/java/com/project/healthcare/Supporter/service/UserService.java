package com.project.healthcare.Supporter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.healthcare.Supporter.dtos.LoginRequest;
import com.project.healthcare.Supporter.dtos.LoginResponse;
import com.project.healthcare.Supporter.dtos.UserDTO;
import com.project.healthcare.Supporter.model.User;
import com.project.healthcare.Supporter.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Autowired
  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public LoginResponse login(LoginRequest request) {
    User user = userRepository.findByEmail(request.getEmail())
        .orElseThrow(() -> new RuntimeException("User not found"));

    if (request.getPassword() == user.getPassword()) {
      throw new RuntimeException("Invalid password");
    }

    return new LoginResponse("Login successful", convertToDTO(user));
  }

  private UserDTO convertToDTO(User user) {
    return new UserDTO(user.getId(), user.getName(), user.getEmail(), user.getRole());
  }
}