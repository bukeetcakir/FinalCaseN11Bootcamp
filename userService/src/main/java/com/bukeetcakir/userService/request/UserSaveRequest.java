package com.bukeetcakir.userService.request;

import com.bukeetcakir.userService.enums.Gender;
import com.bukeetcakir.userService.enums.Status;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record UserSaveRequest(@NotBlank(message = "Name is required")
                              String name,
                              @NotBlank(message = "Surname is required")
                              String surname,
                              @NotNull(message = "Latitude is required")
                              @DecimalMin(value = "-90", message = "Latitude must be between -90 and 90")
                              @DecimalMax(value = "90", message = "Latitude must be between -90 and 90")
                              double latitude,
                              @NotNull(message = "Longitude is required")
                              @DecimalMin(value = "-180", message = "Longitude must be between -180 and 180")
                              @DecimalMax(value = "180", message = "Longitude must be between -180 and 180")
                              double longitude,

                              LocalDate birthDate,

                              @NotBlank(message = "Email is required")
                              @Email(message = "Invalid email format")
                              String email,
                              @NotBlank(message = "New password is required")
                              @Size(min = 8, message = "Password must be at least 8 characters long")
                              String password,

                              Gender gender) {
}
