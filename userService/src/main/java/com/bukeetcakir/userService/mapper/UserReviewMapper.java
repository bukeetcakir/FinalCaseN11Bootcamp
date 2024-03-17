package com.bukeetcakir.userService.mapper;

import com.bukeetcakir.userService.dto.UserReviewDTO;
import com.bukeetcakir.userService.entity.UserReview;
import com.bukeetcakir.userService.request.UserReviewSaveRequest;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserReviewMapper {
    UserReviewMapper INSTANCE = Mappers.getMapper(UserReviewMapper.class);
    UserReview convertToUserReview(UserReviewSaveRequest request);
    UserReview convertToUserReview(UserReviewDTO userReviewDTO);
    UserReviewDTO convertToUserReviewDTO(UserReview userReview);
    List<UserReviewDTO> convertToUserReviewDTOs(List<UserReview> userReviews);


}
