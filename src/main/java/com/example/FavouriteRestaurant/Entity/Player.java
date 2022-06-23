package com.example.FavouriteRestaurant.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long player_id;
    private String firstName;
    private String lastName;
    private String dob;
    private int age;
    private String primary_address;
    private String alternative_address;
    private String office_address;
    private String phone_number;
    private String email;
    private String driving_license;
    private String passport;

    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FavouriteRestaurant> favouriteRestaurants = new ArrayList<>();

    @ManyToOne
    private Restaurant restaurant;
}
