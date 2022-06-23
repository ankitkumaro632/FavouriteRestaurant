package com.example.FavouriteRestaurant.Repoistries;

import com.example.FavouriteRestaurant.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {

    /* find restaurant details by name */
    Restaurant findByName(String name);

    /* find the restaurant and player collection by player name */
/*
    @Query("From Restaurant where player.firstName = :firstName")
*/
    List<Restaurant> findByPlayerFirstName(String firstName);

}
