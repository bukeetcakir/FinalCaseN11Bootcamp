package com.bukeetcakir.restaurantService.entity;

import com.bukeetcakir.restaurantService.general.BaseAdditionalFields;
import com.bukeetcakir.restaurantService.general.BaseModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel {
    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
