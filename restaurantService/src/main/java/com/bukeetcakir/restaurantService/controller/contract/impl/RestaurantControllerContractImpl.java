package com.bukeetcakir.restaurantService.controller.contract.impl;

import com.bukeetcakir.restaurantService.controller.contract.RestaurantControllerContract;
import com.bukeetcakir.restaurantService.dto.RestaurantDTO;
import com.bukeetcakir.restaurantService.entity.Restaurant;
import com.bukeetcakir.restaurantService.mapper.RestaurantMapper;
import com.bukeetcakir.restaurantService.request.RestaurantSaveRequest;
import com.bukeetcakir.restaurantService.request.RestaurantUpdateRequest;
import com.bukeetcakir.restaurantService.service.Calculator;
import com.bukeetcakir.restaurantService.service.RestaurantEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantControllerContractImpl implements RestaurantControllerContract {
    private final RestaurantEntityService restaurantEntityService;

    @Override
    public List<RestaurantDTO> findAll() {
        var restaurants = restaurantEntityService.findAll();
        return RestaurantMapper.INSTANCE.convertToRestaurantDTOs(restaurants);
    }

    @Override
    public List<RestaurantDTO> getRecommendedRestaurantsByUserLocation(double latitude, double longitude) {
        var restaurants = restaurantEntityService.findAll();
        Map<Restaurant, Double> restaurantScores = new HashMap<>();

        // Restoranların puanlarını ve mesafe puanlarını hesapla
        for (var restaurant : restaurants) {
            double distance = Calculator.calculateDistance(restaurant.getLatitude(), restaurant.getLongitude(), latitude, longitude);
            if(distance<=10){
                double score = Calculator.calculateTotalScore(restaurant.getScore(), distance);
                restaurantScores.put(restaurant, score);
            }
        }

        // Skorlara göre sırala
        var recommendedRestaurants = restaurantScores.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) // Skora göre sıralama
                .limit(3) // İlk 3 restoranı seçme
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return RestaurantMapper.INSTANCE.convertToRestaurantDTOs(recommendedRestaurants);
    }

    @Override
    public RestaurantDTO saveRestaurant(RestaurantSaveRequest request) {
        var restaurant = RestaurantMapper.INSTANCE.convertToRestaurant(request);
        restaurant = restaurantEntityService.save(restaurant);

        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantUpdateRequest request) {
        var restaurant = restaurantEntityService.findById(request.id());
        RestaurantMapper.INSTANCE.updateRestaurantFields(restaurant, request);
        restaurantEntityService.save(restaurant);
        return RestaurantMapper.INSTANCE.convertToRestaurantDTO(restaurant);
    }

    @Override
    public void deleteRestaurant(Long userId) {
        var restaurant = restaurantEntityService.findById(userId);
        restaurantEntityService.delete(restaurant);
    }

    @Override
    public void updateRestaurantScore(Long restaurantId, double averageScore) {
        var restaurant = restaurantEntityService.findById(restaurantId);
        restaurant.setScore(averageScore);
        restaurantEntityService.save(restaurant);
    }

}
