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
    private String p_street_no;
    private String p_address_line1;
    private String p_address_line2;
    private String p_city;
    private String p_postal;
    private String p_state;
    private String p_country;
    private String a_street_no;
    private String a_address_line1;
    private String a_address_line2;
    private String a_city;
    private String a_postal;
    private String a_state;
    private String a_country;
    private String o_unit_no;
    private String o_address_line1;
    private String o_address_line2;
    private String o_city;
    private String o_postal;
    private String o_state;
    private String o_country;
    private String phone_number;
    private String email;
    private String driving_license;
    private String passport;

    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<FavouriteRestaurant> favouriteRestaurants = new ArrayList<>();

    @OneToMany(mappedBy = "player",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Mapping> mapping = new ArrayList<>();
}
