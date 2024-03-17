package com.bukeetcakir.userService.exceptions;

import com.bukeetcakir.userService.general.AppBusinessException;
import com.bukeetcakir.userService.general.BaseErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidItemException extends AppBusinessException {
    public InvalidItemException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
