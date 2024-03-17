package com.bukeetcakir.restaurantService.controller;

import com.bukeetcakir.restaurantService.client.UserReviewClient;
import com.bukeetcakir.restaurantService.controller.contract.RestaurantControllerContract;
import com.bukeetcakir.restaurantService.dto.RestaurantDTO;
import com.bukeetcakir.restaurantService.general.RestResponse;
import com.bukeetcakir.restaurantService.request.RestaurantSaveRequest;
import com.bukeetcakir.restaurantService.request.RestaurantUpdateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {
    private final RestaurantControllerContract restaurantControllerContract;
    private final UserReviewClient userReviewClient;

    RestaurantController(RestaurantControllerContract restaurantControllerContract, UserReviewClient userReviewClient) {
        this.restaurantControllerContract = restaurantControllerContract;
        this.userReviewClient = userReviewClient;
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getAllRestaurants() {
        List<RestaurantDTO> restaurants = restaurantControllerContract.findAll();
        for (var restaurant : restaurants) {
            double averageScore = userReviewClient.getAverageScoreByRestaurantId(restaurant.id());
            restaurantControllerContract.updateRestaurantScore(restaurant.id(), averageScore);
        }
        return ResponseEntity.ok(RestResponse.of(restaurants));
    }

    @PostMapping
    public ResponseEntity<RestResponse<RestaurantDTO>> saveRestaurant(@RequestBody RestaurantSaveRequest request) {
        RestaurantDTO restaurantDTO = restaurantControllerContract.saveRestaurant(request);
        return ResponseEntity.ok(RestResponse.of(restaurantDTO));
    }

    @PutMapping("/{restaurantId}")
    public ResponseEntity<RestResponse<RestaurantDTO>> updateRestaurant(@PathVariable @NotNull Long restaurantId, @Valid @RequestBody RestaurantUpdateRequest request) {
        RestaurantDTO restaurantDTO = restaurantControllerContract.updateRestaurant(request);
        return ResponseEntity.ok(RestResponse.of(restaurantDTO));
    }

    @DeleteMapping("/{restaurantId}")
    public void deleteRestaurant(@PathVariable @NotNull Long restaurantId) {
        restaurantControllerContract.deleteRestaurant(restaurantId);
    }

    @GetMapping("/{restaurantId}/averageScore")
    public double getAverageScoreByRestaurantId(@PathVariable Long restaurantId) {
        double score = userReviewClient.getAverageScoreByRestaurantId(restaurantId);
        return score;
    }

    @GetMapping("/recommendations/for-user/{userId}")
    public ResponseEntity<RestResponse<List<RestaurantDTO>>> getRecommendationsForUser(@PathVariable long userId, @RequestParam double latitude, @RequestParam double longitude) {
        var restaurants = restaurantControllerContract.getRecommendedRestaurantsByUserLocation(latitude, longitude);
        return ResponseEntity.ok(RestResponse.of(restaurants));
    }
}
