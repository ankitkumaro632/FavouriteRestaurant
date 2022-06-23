package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {
    private Long player_id;
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


}
