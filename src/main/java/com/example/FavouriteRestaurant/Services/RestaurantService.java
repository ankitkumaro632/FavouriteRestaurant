package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.RestaurantDto;

import java.util.List;

public interface RestaurantService {

    /* save the details of restaurant */
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    /* find the restaurant details by name */
    RestaurantDto findByName(String name);


}
