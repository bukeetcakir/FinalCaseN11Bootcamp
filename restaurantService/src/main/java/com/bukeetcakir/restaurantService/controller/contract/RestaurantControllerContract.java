package com.bukeetcakir.restaurantService.controller.contract;

import com.bukeetcakir.restaurantService.dto.RestaurantDTO;
import com.bukeetcakir.restaurantService.request.RestaurantSaveRequest;
import com.bukeetcakir.restaurantService.request.RestaurantUpdateRequest;

import java.util.List;

public interface RestaurantControllerContract {
    List<RestaurantDTO> findAll();

    List<RestaurantDTO> getRecommendedRestaurantsByUserLocation(double latitude, double longitude);

    RestaurantDTO saveRestaurant(RestaurantSaveRequest request);

    RestaurantDTO updateRestaurant(RestaurantUpdateRequest request);

    void deleteRestaurant(Long userId);

    void updateRestaurantScore(Long restaurantId, double averageScore);

}
