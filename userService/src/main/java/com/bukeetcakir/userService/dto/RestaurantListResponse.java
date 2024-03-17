package com.bukeetcakir.userService.dto;

import java.util.List;

public record RestaurantListResponse(
        List<RestaurantDTO> data,
        String responseDate,
        String messages,
        boolean success
) {}

