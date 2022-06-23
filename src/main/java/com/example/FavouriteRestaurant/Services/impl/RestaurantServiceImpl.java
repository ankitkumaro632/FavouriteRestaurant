package com.example.FavouriteRestaurant.Services.impl;

import com.example.FavouriteRestaurant.Entity.Player;
import com.example.FavouriteRestaurant.Entity.Restaurant;
import com.example.FavouriteRestaurant.Paylods.FavouriteDto;
import com.example.FavouriteRestaurant.Paylods.RestaurantDto;
import com.example.FavouriteRestaurant.Repoistries.PlayerRepo;
import com.example.FavouriteRestaurant.Repoistries.RestaurantRepo;
import com.example.FavouriteRestaurant.Services.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private ModelMapper modelMapper;

    /* create restaurant and save details */
    @Override
    public RestaurantDto createRestaurant(RestaurantDto restaurantDto) {
        Restaurant restaurant = this.dtoToRestaurant(restaurantDto);
        Restaurant savedRestaurant = this.restaurantRepo.save(restaurant);
        return this.restaurantToDto(savedRestaurant);
    }

    /* find restaurant details by name */
    @Override
    public RestaurantDto findByName(String name) {
        Restaurant restaurant = this.restaurantRepo.findByName(name);
        return this.restaurantToDto(restaurant);
    }

    /* get restaurant and player details by player name  */
    @Override
    public List<RestaurantDto> getRestaurantAndPlayerDetails(String firstName) {

        Player player = this.playerRepo.findByFirstName(firstName);

        List<Restaurant> restaurants = this.restaurantRepo.findByPlayerFirstName(firstName);

        List<RestaurantDto> restaurantDto = restaurants.stream().map((restaurant) -> this.modelMapper
                        .map(restaurant, RestaurantDto.class )).collect((Collectors.toList()));

        return restaurantDto;
    }


    /*change the restaurant to dto and dto to restaurant data by the method */
    private Restaurant dtoToRestaurant(RestaurantDto restaurantDto){
        Restaurant restaurant = this.modelMapper.map(restaurantDto,Restaurant.class);
        return restaurant;
    }
    private RestaurantDto restaurantToDto(Restaurant restaurant){
        RestaurantDto restaurantDto = this.modelMapper.map(restaurant,RestaurantDto.class);
        return restaurantDto;
    }
}