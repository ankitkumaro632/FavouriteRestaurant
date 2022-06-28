package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurant_id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Size(min = 10, max = 13, message = "Phone number must be min of 10 chars and max of 13 chars !! ")
    private String contact_number;

    private String r_street_no;
    @NotEmpty
    private String r_address_line1;
    private String r_address_line2;
    @NotEmpty
    private String r_city;
    private String r_postal;
    private String r_state;
    private String r_country;

    @NotEmpty
    private String mondayTiming;
    @NotEmpty
    private String tuesdayTiming;
    @NotEmpty
    private String wednesdayTiming;
    @NotEmpty
    private String thursdayTiming;
    @NotEmpty
    private String fridayTiming;
    @NotEmpty
    private String saturdayTiming;
    @NotEmpty
    private String sundayTiming;


}
