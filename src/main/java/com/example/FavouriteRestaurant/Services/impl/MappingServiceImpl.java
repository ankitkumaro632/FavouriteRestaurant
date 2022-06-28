package com.example.FavouriteRestaurant.Services.impl;

import com.example.FavouriteRestaurant.Entity.Mapping;
import com.example.FavouriteRestaurant.Entity.Player;
import com.example.FavouriteRestaurant.Entity.Restaurant;
import com.example.FavouriteRestaurant.Exception.ResourceNotFoundException;
import com.example.FavouriteRestaurant.Paylods.MappingDto;
import com.example.FavouriteRestaurant.Repoistries.MappingRepo;
import com.example.FavouriteRestaurant.Repoistries.PlayerRepo;
import com.example.FavouriteRestaurant.Repoistries.RestaurantRepo;
import com.example.FavouriteRestaurant.Services.MappingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MappingServiceImpl implements MappingService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private MappingRepo mappingRepo;

    @Autowired
    private PlayerRepo playerRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;


    @Override
    public MappingDto saveMapping(MappingDto mappingDto, Long player_id, Long restaurant_id) {

        Player player = this.playerRepo.findById(player_id).orElseThrow(()->new ResourceNotFoundException(
                "Player","Player id",player_id));

        Restaurant restaurant = this.restaurantRepo.findById(restaurant_id).orElseThrow(()->new
                ResourceNotFoundException("Restaurant","Restaurant id",restaurant_id  ));

        Mapping mapping = this.modelMapper.map(mappingDto, Mapping.class);
        mapping.setPlayer(player);
        mapping.setRestaurant(restaurant);

         Mapping mapping1 = this.mappingRepo.save(mapping);
        return this.modelMapper.map(mapping1, MappingDto.class);

    }

    /* get restaurant and player details by player name  */
    @Override
    public List<MappingDto> findMapping(String firstName) {

        Player player = this.playerRepo.findByFirstName(firstName);
        List<Mapping> mappings = this.mappingRepo.findByPlayerFirstName(firstName);

        List<MappingDto> mappingDtos = mappings.stream().map((mapping) ->
                        this.modelMapper.map(mapping, MappingDto.class ))
                .collect((Collectors.toList()));

        return mappingDtos;

    }

    /*find all player above age by restaurant name and age */
    @Override
    public List<MappingDto> getAllPlayerByRestaurantNameAndPlayerAge(String name, int age) {

        Restaurant restaurant = this.restaurantRepo.findByName(name);
        List<Player> player = this.playerRepo.findByAgeGreaterThanEqual(age);
        List<Mapping> mappings = this.mappingRepo.findByRestaurantNameAndPlayerAgeGreaterThanEqual(name, age);

        List<MappingDto> mappingDtos = mappings.stream().map((mapping)-> this.modelMapper
                .map(mapping,MappingDto.class)).collect(Collectors.toList());
        return mappingDtos;
    }
}
