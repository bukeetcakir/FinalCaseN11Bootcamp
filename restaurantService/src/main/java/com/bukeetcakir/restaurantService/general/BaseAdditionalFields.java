package com.bukeetcakir.restaurantService.general;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
