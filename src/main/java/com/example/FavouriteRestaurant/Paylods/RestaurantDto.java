package com.example.FavouriteRestaurant.Paylods;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RestaurantDto {
    private Long restaurant_id;

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

}
