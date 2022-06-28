package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.MappingDto;

import java.util.List;

public interface MappingService {

    /* create a mapping and save the details */
    MappingDto saveMapping(MappingDto mappingDto,Long player_id, Long restaurant_id);

    /* find the restaurant and player mapping */
    List<MappingDto> findMapping(String firstName);

    /* find the all player above 60 by restaurant name */
    List<MappingDto> getAllPlayerByRestaurantNameAndPlayerAge(String name, int age);
}
