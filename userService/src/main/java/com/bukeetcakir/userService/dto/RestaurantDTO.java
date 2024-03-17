package com.bukeetcakir.userService.dto;

import com.bukeetcakir.userService.enums.Status;

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
