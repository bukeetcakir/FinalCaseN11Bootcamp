package com.bukeetcakir.userService.controller;

import com.bukeetcakir.userService.client.RestaurantServiceClient;
import com.bukeetcakir.userService.controller.contract.UserControllerContract;
import com.bukeetcakir.userService.dto.RestaurantListResponse;
import com.bukeetcakir.userService.dto.UserDTO;
import com.bukeetcakir.userService.general.RestResponse;
import com.bukeetcakir.userService.request.UserSaveRequest;
import com.bukeetcakir.userService.request.UserUpdatePasswordRequest;
import com.bukeetcakir.userService.request.UserUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    UserControllerContract userControllerContract;
    private final RestaurantServiceClient restaurantServiceClient;

    UserController(UserControllerContract userControllerContract, RestaurantServiceClient restaurantServiceClient) {
        this.userControllerContract = userControllerContract;
        this.restaurantServiceClient = restaurantServiceClient;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(users));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserDTO>> saveUser(@RequestBody UserSaveRequest request) {
        UserDTO userDTO = userControllerContract.saveUser(request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<RestResponse<UserDTO>> updateUser(@PathVariable @NotNull Long userId, @Valid @RequestBody UserUpdateRequest request) {
        UserDTO userDTO = userControllerContract.updateUser(userId, request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @PatchMapping("/{userId}/password")
    public ResponseEntity<RestResponse<UserDTO>> updateUserPassword(@PathVariable @NotNull Long userId, @Valid @RequestBody UserUpdatePasswordRequest request) {
        UserDTO userDTO = userControllerContract.updateUserPassword(userId, request);
        return ResponseEntity.ok(RestResponse.of(userDTO));
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable @NotNull Long userId) {
        userControllerContract.deleteUser(userId);
    }

    @GetMapping("/{userId}/recommendations")
    public RestaurantListResponse getRecommendedRestaurants(@PathVariable Long userId) {
        var user = userControllerContract.findUserById(userId);
        var restaurants = restaurantServiceClient.getRecommendationsForUser(userId, user.latitude(), user.longitude());
        return restaurants;
    }

}
