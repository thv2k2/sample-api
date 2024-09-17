package org.sample.api.service;

import jakarta.transaction.Transactional;

import org.sample.api.dto.AuthDto;
import org.sample.common.entity.User;

public interface AuthService {
  User getUser(Long userId);

  @Transactional
  AuthDto.UserDto createNewUser(AuthDto.CreateUserRequest request);

  AuthDto.LoginResponse login(AuthDto.LoginRequest request);
}
