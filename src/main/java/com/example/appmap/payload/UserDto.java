package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    @NotNull(message = "User name must not be empty")
    private String name;

    @NotNull(message = "User family name must not be empty")
    private String familyName;

    @NotNull(message = "User country must not be empty")
    private Integer countryId;

    @NotNull(message = "User region must not be empty")
    private Integer regionId;

    @NotNull(message = "User city must not be empty")
    private Integer cityId;

    @NotNull(message = "User address must not be empty")
    private String address;

    @NotNull(message = "User company must not be empty")
    private String company;

    @NotNull(message = "User model must not be empty")
    private String model;

    @NotNull(message = "User number must not be empty")
    private String number;
}
