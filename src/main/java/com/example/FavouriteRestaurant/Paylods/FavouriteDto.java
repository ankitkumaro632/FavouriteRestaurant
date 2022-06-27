package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavouriteDto {

    private boolean favouriteRestaurant;

    private PlayerDto player;

    private RestaurantDto restaurant;
}
