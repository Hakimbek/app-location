package com.example.appmap.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegionDto {

    @NotBlank(message = "There was a problem with your region name")
    private String regionName;

}
