package org.sample.api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.sample.api.dto.AuthDto;
import org.sample.common.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
  @Mapping(target = "fullName", source = "fullname")
  User fromCreateUserRequestToUser(AuthDto.CreateUserRequest request);

  @Mapping(target = "fullname", source = "fullName")
  AuthDto.UserDto fromUserEntityToUserDto(User user);
}
