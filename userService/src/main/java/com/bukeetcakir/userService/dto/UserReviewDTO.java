package com.bukeetcakir.userService.dto;

import com.bukeetcakir.userService.enums.Score;

public record UserReviewDTO(Long id,
                            Long userId,
                            Long restaurantId,
                            Score score,
                            String text
) {

}
