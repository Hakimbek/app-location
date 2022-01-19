package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegionDto {

    @NotBlank(message = "There is a problem with your region name")
    private String regionName;

    @Min(value = 1, message = "There is a problem with your country id")
    private Integer countryId;

}
