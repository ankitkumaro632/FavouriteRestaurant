package com.example.FavouriteRestaurant.Repoistries;

import com.example.FavouriteRestaurant.Entity.FavouriteRestaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FavouriteRepo extends JpaRepository<FavouriteRestaurant,Long> {
    List<FavouriteRestaurant> findByPlayerFirstName(String firstName);

}
