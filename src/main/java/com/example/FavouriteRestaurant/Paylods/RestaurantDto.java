package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurant_id;

    private String name;

    private String contact_number;

    private String hoursOfOperation;

    /*private List<PlayerDto> playerDto;*/
}
