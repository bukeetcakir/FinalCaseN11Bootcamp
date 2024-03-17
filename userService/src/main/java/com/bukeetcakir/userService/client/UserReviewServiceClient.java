package com.bukeetcakir.userService.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "user-service", url = "http://localhost:8080/api/v1/user-reviews")
public interface UserReviewServiceClient {

    @GetMapping("/restaurant/{restaurantId}/averageScore")
    double getAverageScoreByRestaurantId(@PathVariable Long restaurantId);
}
