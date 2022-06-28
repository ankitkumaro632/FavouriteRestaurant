package com.example.FavouriteRestaurant.Services;

import com.example.FavouriteRestaurant.Paylods.PlayerDto;


public interface PlayerService {

   /* create a player and save the database */
   PlayerDto createPlayer(PlayerDto playerDto);

   /* find the player details by player first and last name */
   PlayerDto getPlayerByName( String firstName,String lastName);



}
