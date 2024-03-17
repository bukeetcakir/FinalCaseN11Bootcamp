package com.bukeetcakir.restaurantService.mapper;

import com.bukeetcakir.restaurantService.dto.RestaurantDTO;
import com.bukeetcakir.restaurantService.entity.Restaurant;
import com.bukeetcakir.restaurantService.request.RestaurantSaveRequest;
import com.bukeetcakir.restaurantService.request.RestaurantUpdateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    Restaurant convertToRestaurant(RestaurantSaveRequest request);
    Restaurant convertToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO convertToRestaurantDTO(Restaurant restaurant);
    List<RestaurantDTO> convertToRestaurantDTOs(List<Restaurant> restaurant);
    @Mapping(target = "id", ignore = true)
    void updateRestaurantFields(@MappingTarget Restaurant restaurant, RestaurantUpdateRequest request);

}
