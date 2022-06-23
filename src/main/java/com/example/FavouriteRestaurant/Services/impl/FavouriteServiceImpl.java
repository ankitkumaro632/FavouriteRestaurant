package com.example.FavouriteRestaurant.Services.impl;

import com.example.FavouriteRestaurant.Entity.FavouriteRestaurant;
import com.example.FavouriteRestaurant.Entity.Player;
import com.example.FavouriteRestaurant.Entity.Restaurant;
import com.example.FavouriteRestaurant.Exception.ResourceNotFoundException;
import com.example.FavouriteRestaurant.Paylods.FavouriteDto;
import com.example.FavouriteRestaurant.Repoistries.FavouriteRepo;
import com.example.FavouriteRestaurant.Repoistries.PlayerRepo;
import com.example.FavouriteRestaurant.Repoistries.RestaurantRepo;
import com.example.FavouriteRestaurant.Services.FavouriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepo favouriteRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PlayerRepo playerRepo;
    @Autowired
    private RestaurantRepo restaurantRepo;


    /* create the favourite restaurant by player and restaurant name */
    @Override
    public FavouriteDto createFavouriteRestaurant(FavouriteDto favouriteDto,
                                                            Long player_id, Long restaurant_id) {
        Player player = this.playerRepo.findById(player_id).orElseThrow(()->new ResourceNotFoundException(
                "Player","Player id",player_id));

        Restaurant restaurant = this.restaurantRepo.findById(restaurant_id).orElseThrow(()->new ResourceNotFoundException(
      "Restaurant","Restaurant id",restaurant_id  ));

        FavouriteRestaurant favouriteRestaurant = this.modelMapper.map(favouriteDto, FavouriteRestaurant.class);
        favouriteRestaurant.setPlayer(player);
        favouriteRestaurant.setRestaurant(restaurant);

        FavouriteRestaurant favouriteRestaurant1 = this.favouriteRepo.save(favouriteRestaurant);

        return this.modelMapper.map(favouriteRestaurant1,FavouriteDto.class);
    }

    /* find the favourite restaurant by player name */
    @Override
    public List<FavouriteDto> getFavouriteRestaurantByPlayerName(String firstName) {
            Player player = this.playerRepo.findByFirstName(firstName);
            List<FavouriteRestaurant> favouriteRestaurant = this.favouriteRepo.findByPlayerFirstName(firstName);

            List<FavouriteDto> favouriteDto = favouriteRestaurant.stream().map((favouriteRestaurant1) ->
                            this.modelMapper.map(favouriteRestaurant1, FavouriteDto.class ))
                    .collect((Collectors.toList()));

            return favouriteDto;
    }


}
