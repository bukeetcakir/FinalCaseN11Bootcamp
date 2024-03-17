package com.bukeetcakir.userService.service;

import com.bukeetcakir.userService.entity.UserReview;
import com.bukeetcakir.userService.repository.UserReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReviewEntityService extends BaseEntityService<UserReview, UserReviewRepository> {
    protected UserReviewEntityService(UserReviewRepository repository) {
        super(repository);
    }
    public List<UserReview> findAllByUserId(Long userId){
        return getRepository().findAllByUserId(userId);
    }
    public List<UserReview> findAllByRestaurantId(Long restaurantId){
       return getRepository().findAllByRestaurantId(restaurantId);
    }

}
