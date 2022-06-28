package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class FavouriteDto {

    @NotEmpty
    private boolean favouriteRestaurant;

    private PlayerDto player;

    private RestaurantDto restaurant;
}
