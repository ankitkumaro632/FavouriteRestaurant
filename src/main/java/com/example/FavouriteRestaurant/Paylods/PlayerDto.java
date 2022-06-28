package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
public class PlayerDto {
    private Long player_id;
    @NotEmpty
    private String firstName;
    private String lastName;

    private String dob;
    @NotEmpty
    private int age;
    private String p_street_no;
    @NotEmpty
    private String p_address_line1;
    private String p_address_line2;
    @NotEmpty
    private String p_city;
    @NotEmpty
    private String p_postal;
    @NotEmpty
    private String p_state;
    @NotEmpty
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
    @NotEmpty
    @Size(min = 10, max = 13, message = "Phone number must be min of 10 chars and max of 13 chars !! ")
    private String phone_number;
    @Email
    private String email;
    private String driving_license;
    private String passport;


}
