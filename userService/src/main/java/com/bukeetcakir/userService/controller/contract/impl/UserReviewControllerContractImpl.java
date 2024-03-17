package com.bukeetcakir.userService.controller.contract.impl;

import com.bukeetcakir.userService.controller.contract.UserReviewControllerContract;
import com.bukeetcakir.userService.dto.UserReviewDTO;
import com.bukeetcakir.userService.entity.UserReview;
import com.bukeetcakir.userService.mapper.UserReviewMapper;
import com.bukeetcakir.userService.request.UserReviewSaveRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateScoreRequest;
import com.bukeetcakir.userService.request.UserReviewUpdateTextRequest;
import com.bukeetcakir.userService.service.UserReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserReviewControllerContractImpl implements UserReviewControllerContract {
    private final UserReviewEntityService userReviewEntityService;

    @Override
    public List<UserReviewDTO> findAll() {
        List<UserReview> userReviewList = userReviewEntityService.findAll();
        return UserReviewMapper.INSTANCE.convertToUserReviewDTOs(userReviewList);
    }

    public List<UserReviewDTO> findAllUserReviewsByRestaurantId(Long restaurantId) {
        List<UserReview> userReviewList = userReviewEntityService.findAllByRestaurantId(restaurantId);
        return UserReviewMapper.INSTANCE.convertToUserReviewDTOs(userReviewList);
    }

    @Override
    public UserReviewDTO saveUserReview(UserReviewSaveRequest request) {
        var userReview = UserReviewMapper.INSTANCE.convertToUserReview(request);
        userReview = userReviewEntityService.save(userReview);
        return UserReviewMapper.INSTANCE.convertToUserReviewDTO(userReview);
    }


    @Override
    public UserReviewDTO updateUserReviewText(Long userReviewId, UserReviewUpdateTextRequest request) {
        var userReview = userReviewEntityService.findById(userReviewId);
        userReview.setText(request.text());
        userReviewEntityService.save(userReview);

        return UserReviewMapper.INSTANCE.convertToUserReviewDTO(userReview);
    }

    @Override
    public UserReviewDTO updateUserReviewScore(Long userReviewId, UserReviewUpdateScoreRequest request) {
        var userReview = userReviewEntityService.findById(userReviewId);
        userReview.setScore(request.score());
        userReviewEntityService.save(userReview);

        return UserReviewMapper.INSTANCE.convertToUserReviewDTO(userReview);
    }

    @Override
    public void deleteUserReview(Long userReviewId) {
        var userReview = userReviewEntityService.findById(userReviewId);
        userReviewEntityService.delete(userReview);
    }

    @Override
    public double getAverageScoreByRestaurantId(Long restaurantId) {
        var userReviews = userReviewEntityService.findAllByRestaurantId(restaurantId);
        return userReviews.stream()
                .mapToInt(review -> review.getScore().getValue())
                .average()
                .orElse(0.0);
    }



}
