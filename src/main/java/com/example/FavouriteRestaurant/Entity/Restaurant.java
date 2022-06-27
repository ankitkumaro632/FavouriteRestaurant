package com.example.FavouriteRestaurant.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurant_id;

    private String name;

    private String contact_number;

    private String r_street_no;
    private String r_address_line1;
    private String r_address_line2;
    private String r_city;
    private String r_postal;
    private String r_state;
    private String r_country;

    private String hoursOfOperation;

    @OneToMany(mappedBy = "restaurant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FavouriteRestaurant> favouriteRestaurant = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mapping> mappings = new ArrayList<>();
}
