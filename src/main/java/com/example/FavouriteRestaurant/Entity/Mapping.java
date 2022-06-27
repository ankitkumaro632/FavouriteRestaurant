package com.example.FavouriteRestaurant.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mapping")
@Getter
@Setter
@NoArgsConstructor
public class Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mapping_id;

    @ManyToOne
    private Player player;

    @ManyToOne
    private Restaurant restaurant;
}
