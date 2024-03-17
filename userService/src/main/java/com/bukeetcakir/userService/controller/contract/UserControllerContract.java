package com.bukeetcakir.userService.controller.contract;

import com.bukeetcakir.userService.dto.UserDTO;
import com.bukeetcakir.userService.request.UserSaveRequest;
import com.bukeetcakir.userService.request.UserUpdatePasswordRequest;
import com.bukeetcakir.userService.request.UserUpdateRequest;

import java.util.List;

public interface UserControllerContract {
    List<UserDTO> findAll();

    UserDTO findUserById(Long userId);

    UserDTO saveUser(UserSaveRequest request);

    UserDTO updateUser(Long userId, UserUpdateRequest request);

    void deleteUser(Long userId);
    UserDTO updateUserPassword(Long userId, UserUpdatePasswordRequest request);
}
