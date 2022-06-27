package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurant_id;

    private String name;

    private String contact_number;

    private String hoursOfOperation;

}
