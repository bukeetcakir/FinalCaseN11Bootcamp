package com.bukeetcakir.userService.request;

import com.bukeetcakir.userService.enums.Score;

public record UserReviewUpdateScoreRequest(Long id,
                                           Score score) {
}
