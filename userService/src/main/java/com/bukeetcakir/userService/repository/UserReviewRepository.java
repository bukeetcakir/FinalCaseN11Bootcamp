package com.bukeetcakir.userService.repository;

import com.bukeetcakir.userService.entity.UserReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReviewRepository extends JpaRepository<UserReview, Long> {

    List<UserReview> findAllByUserId(Long userId);
    List<UserReview> findAllByRestaurantId (Long restaurantId);

}
