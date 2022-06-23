package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.PlayerDto;

import java.util.List;

public interface PlayerService {

   /* create a player and save the database */
   PlayerDto createPlayer(PlayerDto playerDto);

   /* find the player details by player first and last name */
   PlayerDto getPlayerByName( String firstName,String lastName);

   /* find the all player above 60 by restaurant name */
   List<PlayerDto> getAllPlayerByRestaurantName(String name, int age);

}