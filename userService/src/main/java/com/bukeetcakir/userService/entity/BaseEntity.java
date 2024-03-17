package com.bukeetcakir.userService.entity;

import com.bukeetcakir.userService.general.BaseAdditionalFields;
import com.bukeetcakir.userService.general.BaseModel;
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
