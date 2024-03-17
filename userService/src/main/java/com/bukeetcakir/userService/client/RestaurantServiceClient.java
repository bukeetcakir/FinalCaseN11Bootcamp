package com.bukeetcakir.userService.client;

import com.bukeetcakir.userService.dto.RestaurantListResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "restaurant-service", url = "http://localhost:8081/api/v1/restaurants")
public interface RestaurantServiceClient {

    @GetMapping("/recommendations/for-user/{userId}")
    RestaurantListResponse getRecommendationsForUser(@PathVariable Long userId, @RequestParam double latitude, @RequestParam double longitude);
}
