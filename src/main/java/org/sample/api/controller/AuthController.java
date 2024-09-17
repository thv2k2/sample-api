package org.sample.api.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.sample.api.dto.AuthDto;
import org.sample.api.service.AuthService;
import org.sample.common.entity.User;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {
  private final AuthService authService;

  @GetMapping("/{userId}")
  public ResponseEntity<User> getUser(@PathVariable("userId") Long userId) {
    return ResponseEntity.ok(authService.getUser(userId));
  }

  @PutMapping("/create")
  public ResponseEntity<AuthDto.UserDto> createUser(
      @RequestBody AuthDto.CreateUserRequest request) {
    return ResponseEntity.ok(authService.createNewUser(request));
  }

    @PostMapping("/login")
    public ResponseEntity<AuthDto.LoginResponse> login(@RequestBody AuthDto.LoginRequest request) {
      return ResponseEntity.ok(authService.login(request));
    }
}
