package com.example.FavouriteRestaurant.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "favourite_restaurant")
@Getter
@Setter
@NoArgsConstructor
public class FavouriteRestaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean favouriteRestaurant;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Restaurant restaurant;


}
