package com.bukeetcakir.restaurantService.dto;

import com.bukeetcakir.restaurantService.enums.Status;


public record RestaurantDTO(Long id,
                            String name,

                            double latitude,
                            double longitude,
                            String phoneNumber,
                            String address,
                            String email,
                            double score,
                            Status status) {
}
