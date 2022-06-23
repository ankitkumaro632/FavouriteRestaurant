package com.example.FavouriteRestaurant.Paylods;

import com.example.FavouriteRestaurant.Entity.Player;
import com.example.FavouriteRestaurant.Entity.Restaurant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavouriteDto {
    private boolean favouriteRestaurant;
    private PlayerDto player;
    /*private RestaurantDto restaurant;*/
}
