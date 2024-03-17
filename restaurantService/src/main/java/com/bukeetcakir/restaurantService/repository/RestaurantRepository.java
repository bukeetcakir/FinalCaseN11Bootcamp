package com.bukeetcakir.restaurantService.repository;

import com.bukeetcakir.restaurantService.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

}
