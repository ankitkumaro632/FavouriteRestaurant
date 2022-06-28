package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.FavouriteDto;

import java.util.List;

public interface FavouriteService {
    /* create a favourite restaurant */
    FavouriteDto createFavouriteRestaurant(FavouriteDto favouriteDto,Long player_id, Long restaurant_id);

    /*find favourite restaurant by player name */
    List<FavouriteDto> getFavouriteRestaurantByPlayerName(String firstName);


}
