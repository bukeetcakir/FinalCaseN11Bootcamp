package com.bukeetcakir.userService.controller.contract;

import com.bukeetcakir.userService.dto.UserReviewDTO;
import com.bukeetcakir.userService.request.UserReviewSaveRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateScoreRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateTextRequest;

import java.util.List;

public interface UserReviewControllerContract {
    List<UserReviewDTO> findAll();
    UserReviewDTO saveUserReview(UserReviewSaveRequest request);
    UserReviewDTO updateUserReviewText(Long userReviewId, UserReviewUpdateTextRequest request);
    UserReviewDTO updateUserReviewScore(Long userReviewId, UserReviewUpdateScoreRequest request);
    void deleteUserReview(Long userReviewId);
    double getAverageScoreByRestaurantId(Long restaurantId);


}
