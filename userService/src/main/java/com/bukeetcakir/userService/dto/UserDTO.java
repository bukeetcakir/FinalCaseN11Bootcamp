package com.bukeetcakir.userService.dto;

import com.bukeetcakir.userService.enums.Gender;
import com.bukeetcakir.userService.enums.Status;

import java.time.LocalDate;

public record UserDTO(Long id,
                      String name,
                      String surname,
                      double latitude,
                      double longitude,
                      LocalDate birthDate,
                      String email,
                      String password,
                      Gender gender,
                      Status status) {
}
