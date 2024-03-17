package com.bukeetcakir.restaurantService.service;

import com.bukeetcakir.restaurantService.entity.Restaurant;
import com.bukeetcakir.restaurantService.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

@Service
public class RestaurantEntityService extends BaseEntityService<Restaurant, RestaurantRepository> {
    protected RestaurantEntityService(RestaurantRepository repository) {
        super(repository);
    }
}
