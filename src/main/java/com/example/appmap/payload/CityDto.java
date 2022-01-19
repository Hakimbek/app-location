package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityDto {

    @NotBlank(message = "There is a problem with your city name")
    private String city;

    @NotBlank(message = "There is a problem with your region id")
    private Integer regionId;

}
