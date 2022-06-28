package com.example.FavouriteRestaurant.Repoistries;

import com.example.FavouriteRestaurant.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {

    /* find restaurant details by name */
    Restaurant findByName(String name);


}
