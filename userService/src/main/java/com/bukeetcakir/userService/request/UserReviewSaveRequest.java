package com.bukeetcakir.userService.request;

import com.bukeetcakir.userService.enums.Score;

public record UserReviewSaveRequest(Long userId,
                                    Long restaurantId,
                                    Score score,
                                    String text) {
}
