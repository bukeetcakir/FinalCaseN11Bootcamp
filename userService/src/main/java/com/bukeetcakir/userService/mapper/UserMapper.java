package com.bukeetcakir.userService.mapper;

import com.bukeetcakir.userService.dto.UserDTO;
import com.bukeetcakir.userService.entity.User;
import com.bukeetcakir.userService.request.UserSaveRequest;
import com.bukeetcakir.userService.request.UserUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User convertToUser(UserSaveRequest request);
    User convertToUser(UserDTO userDTO);

    UserDTO convertToUserDTO(User user);
    List<UserDTO> convertToUserDTOs(List<User> user);
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    void updateUserFields(@MappingTarget User user, UserUpdateRequest request);

}
