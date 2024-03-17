package com.bukeetcakir.userService.controller;

import com.bukeetcakir.userService.controller.contract.impl.UserReviewControllerContractImpl;
import com.bukeetcakir.userService.dto.UserReviewDTO;
import com.bukeetcakir.userService.general.RestResponse;
import com.bukeetcakir.userService.request.UserReviewSaveRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateScoreRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateTextRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-reviews")
public class UserReviewController {
    private final UserReviewControllerContractImpl userReviewControllerContract;

    public UserReviewController(UserReviewControllerContractImpl userReviewControllerContract) {
        this.userReviewControllerContract = userReviewControllerContract;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<UserReviewDTO>>> getAllUserReviews() {
        var userReviewDTOs = userReviewControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(userReviewDTOs));
    }

    @PostMapping
    public ResponseEntity<RestResponse<UserReviewDTO>> save(@RequestBody UserReviewSaveRequest request) {
        var userReviewDTO = userReviewControllerContract.saveUserReview(request);
        return ResponseEntity.ok(RestResponse.of(userReviewDTO));
    }


    @PatchMapping("/{id}/text")
    public ResponseEntity<RestResponse<UserReviewDTO>> updateUserReviewText(@PathVariable Long id, @RequestBody UserReviewUpdateTextRequest request) {
        var userReviewDTO = userReviewControllerContract.updateUserReviewText(id, request);
        return ResponseEntity.ok(RestResponse.of(userReviewDTO));
    }

    @PatchMapping("/{id}/score")
    public ResponseEntity<RestResponse<UserReviewDTO>> updateUserReviewScore(@PathVariable Long id, @RequestBody UserReviewUpdateScoreRequest request) {
        var userReviewDTO = userReviewControllerContract.updateUserReviewScore(id, request);
        return ResponseEntity.ok(RestResponse.of(userReviewDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteUserReview(@PathVariable Long id) {
        userReviewControllerContract.deleteUserReview(id);
    }


    @GetMapping("/restaurant/{restaurantId}/averageScore")
    public double getAverageScoreByRestaurantId(@PathVariable Long restaurantId) {
        return userReviewControllerContract.getAverageScoreByRestaurantId(restaurantId);
    }

}
