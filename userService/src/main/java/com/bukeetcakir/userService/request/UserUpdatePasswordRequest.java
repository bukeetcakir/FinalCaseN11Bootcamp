package com.bukeetcakir.userService.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdatePasswordRequest(@NotBlank(message = "New password is required")
                                        @Size(min = 8, message = "Password must be at least 8 characters long")
                                        String oldPassword,
                                        @NotBlank(message = "New password is required")
                                        @Size(min = 8, message = "Password must be at least 8 characters long")
                                        String password1,
                                        @NotBlank(message = "New password is required")
                                        @Size(min = 8, message = "Password must be at least 8 characters long")
                                        String password2) {
}
