package com.example.FavouriteRestaurant.Services.impl;

import com.example.FavouriteRestaurant.Entity.Player;
import com.example.FavouriteRestaurant.Entity.Restaurant;
import com.example.FavouriteRestaurant.Paylods.PlayerDto;
import com.example.FavouriteRestaurant.Repoistries.PlayerRepo;
import com.example.FavouriteRestaurant.Repoistries.RestaurantRepo;
import com.example.FavouriteRestaurant.Services.PlayerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestaurantRepo restaurantRepo;

    /* create the player  */
    @Override
    public PlayerDto createPlayer(PlayerDto playerDto) {

        Player player = this.dtoToPlayer(playerDto);
        Player savedPlayer = this.playerRepo.save(player);
        return this.playerToDto(savedPlayer);
    }

    /* find the player by player name */
    @Override
    public PlayerDto getPlayerByName(String firstName, String lastname) {
        Player player = this.playerRepo.findByFirstNameAndLastName(firstName,lastname);
        return this.playerToDto(player);
    }



    /* create a method to change player to dto and dto to player */



    private Player dtoToPlayer(PlayerDto playerDto){
        Player player = this.modelMapper.map(playerDto,Player.class);
        return player;
    }
    private PlayerDto playerToDto(Player player){
        PlayerDto playerDto = this.modelMapper.map(player,PlayerDto.class);
        return playerDto;
    }
}

