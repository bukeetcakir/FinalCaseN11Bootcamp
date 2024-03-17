package com.bukeetcakir.restaurantService.exceptions;

import com.bukeetcakir.restaurantService.general.AppBusinessException;
import com.bukeetcakir.restaurantService.general.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends AppBusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
