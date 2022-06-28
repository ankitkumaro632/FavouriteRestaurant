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
    private String mondayOpeningTime;
    @NotEmpty
    private String mondayClosingTime;
    @NotEmpty
    private String tuesdayOpeningTime;
    @NotEmpty
    private String tuesdayClosingTime;
    @NotEmpty
    private String wednesdayOpeningTime;
    @NotEmpty
    private String wednesdayClosingTime;
    @NotEmpty
    private String thursdayOpeningTime;
    @NotEmpty
    private String thursdayClosingTime;
    @NotEmpty
    private String fridayOpeningTime;
    @NotEmpty
    private String fridayClosingTime;
    @NotEmpty
    private String saturdayOpeningTime;
    @NotEmpty
    private String saturdayClosingTime;
    @NotEmpty
    private String sundayOpeningTime;
    @NotEmpty
    private String sundayClosingTime;


}
