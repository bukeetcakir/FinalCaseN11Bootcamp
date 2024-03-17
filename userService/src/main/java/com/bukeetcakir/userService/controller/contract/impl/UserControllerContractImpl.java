package com.bukeetcakir.userService.controller.contract.impl;

import com.bukeetcakir.userService.controller.contract.UserControllerContract;
import com.bukeetcakir.userService.dto.UserDTO;
import com.bukeetcakir.userService.enums.Status;
import com.bukeetcakir.userService.exceptions.InvalidItemException;
import com.bukeetcakir.userService.general.GeneralErrorMessage;
import com.bukeetcakir.userService.mapper.UserMapper;
import com.bukeetcakir.userService.request.UserSaveRequest;
import com.bukeetcakir.userService.request.UserUpdatePasswordRequest;
import com.bukeetcakir.userService.request.UserUpdateRequest;
import com.bukeetcakir.userService.service.UserEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserControllerContractImpl implements UserControllerContract {
    private final UserEntityService userEntityService;

    @Override
    public List<UserDTO> findAll() {
        var users = userEntityService.findAll();
        return UserMapper.INSTANCE.convertToUserDTOs(users);
    }

    @Override
    public UserDTO findUserById(Long userId) {
        var user = userEntityService.findById(userId);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public UserDTO saveUser(UserSaveRequest request) {
        var user = UserMapper.INSTANCE.convertToUser(request);
        user.setStatus(Status.PASSIVE);
        user = userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public UserDTO updateUser(Long userId, UserUpdateRequest request) {
        var user = userEntityService.findById(userId);
        UserMapper.INSTANCE.updateUserFields(user, request);
        user.setId(userId);
        user.setStatus(Status.ACTIVE);
        userEntityService.save(user);
        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public UserDTO updateUserPassword(Long userId, UserUpdatePasswordRequest request) {
        var user = userEntityService.findById(userId);

        if (!user.getPassword().equals(request.oldPassword())) {
            throw new InvalidItemException(GeneralErrorMessage.INVALID_PASSWORD);
        }

        if (!request.password1().equals(request.password2()) || request.oldPassword().equals(request.password1())) {
            throw new InvalidItemException(GeneralErrorMessage.INVALID_PASSWORD);
        }

        user.setPassword(request.password1());
        userEntityService.save(user);

        return UserMapper.INSTANCE.convertToUserDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        var user = userEntityService.findById(userId);
        userEntityService.delete(user);
    }
}
