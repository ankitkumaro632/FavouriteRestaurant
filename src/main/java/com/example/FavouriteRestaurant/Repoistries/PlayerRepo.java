package com.example.FavouriteRestaurant.Repoistries;

import com.example.FavouriteRestaurant.Entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

    /*find player details by player name*/
    Player findByFirstNameAndLastName(String firstName, String lastName);

    /*find player and favourite restaurant collection by player name */
    Player findByFirstName(String firstName);

    /* find the age */
    List<Player> findByAgeGreaterThanEqual(int age);




}
