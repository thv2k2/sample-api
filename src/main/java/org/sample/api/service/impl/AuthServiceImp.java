package org.sample.api.service.impl;

import java.sql.Timestamp;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import org.sample.api.dto.AuthDto;
import org.sample.api.exception.BusinessCode;
import org.sample.api.exception.BusinessException;
import org.sample.api.mapper.UserMapper;
import org.sample.api.repository.UserRepository;
import org.sample.api.service.AuthService;
import org.sample.common.entity.User;
import org.sample.common.numberic.RoleUser;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public User getUser(Long userId) {
    return userRepository.findUserById(userId).orElse(null);
  }

  @Override
  public AuthDto.UserDto createNewUser(AuthDto.CreateUserRequest request) {
    User user = userRepository.findUserByUsername(request.getUsername()).orElse(null);

    if (user != null) {
      return userMapper.fromUserEntityToUserDto(user);
    }

    User newUser = userMapper.fromCreateUserRequestToUser(request);
    Timestamp currentDate = new Timestamp(System.currentTimeMillis());
    newUser.setCreatedAt(currentDate);
    newUser.setUpdatedAt(currentDate);
    newUser.setIsDeleted(false);
    newUser.setRole(RoleUser.USER);

    return userMapper.fromUserEntityToUserDto(userRepository.save(newUser));
  }

  @Override
  public AuthDto.LoginResponse login(AuthDto.LoginRequest request) {
    User user = userRepository.findUserByUsername(request.getUsername()).orElse(null);

    if (Objects.isNull(user) || !user.getPassword().equals(request.getPassword())) {
      throw new BusinessException(BusinessCode.USERNAME_OR_PASSWORD_NOT_FOUND);
    }

    return AuthDto.LoginResponse.builder()
        .role(user.getRole())
        .username(user.getUsername())
        .token("token")
        .build();
  }
}
