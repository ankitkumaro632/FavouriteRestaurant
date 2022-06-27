package com.example.FavouriteRestaurant.Repoistries;

import com.example.FavouriteRestaurant.Entity.Mapping;
import com.example.FavouriteRestaurant.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MappingRepo extends JpaRepository<Mapping,Long> {

    /* find the restaurant and player mapping */
    List<Mapping> findByPlayerFirstName(String firstName);

    /* find all player above 60 by restaurant name */
    List<Mapping> findByRestaurantNameAndPlayerAgeGreaterThanEqual(String name, int age);
}
