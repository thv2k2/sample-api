package org.sample.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import org.sample.common.numberic.RoleUser;

public class AuthDto {

  @Getter
  @Setter
  @Builder
  public static class CreateUserRequest {
    private String username;
    private String password;
    private String fullname;
  }

  @Getter
  @Setter
  @Builder
  public static class UserDto {
    private String username;
    private String fullname;
    private RoleUser role;
  }

  @Getter
  @Setter
  @Builder
  public static class LoginRequest {
    private String username;
    private String password;
  }

  @Getter
  @Setter
  @Builder
  public static class LoginResponse {
    private String username;
    private RoleUser role;
    private String token;
  }
}
