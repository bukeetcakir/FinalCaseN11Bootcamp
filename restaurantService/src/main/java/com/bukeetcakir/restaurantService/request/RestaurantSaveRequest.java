package com.bukeetcakir.restaurantService.request;

import com.bukeetcakir.restaurantService.enums.Status;

public record RestaurantSaveRequest(
                                    String name,
                                    double latitude,
                                    double longitude,
                                    String phoneNumber,
                                    String address,
                                    String email,
                                    Status status) {
}
