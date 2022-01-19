package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CountryDto {

    @NotBlank(message = "There was a problem with your country name")
    private String country;

}
