package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.RestaurantDto;


public interface RestaurantService {

    /* save the details of restaurant */
    RestaurantDto createRestaurant(RestaurantDto restaurantDto);

    /* find the restaurant details by name */
    RestaurantDto findByName(String name);


}
