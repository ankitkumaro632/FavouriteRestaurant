package com.example.FavouriteRestaurant.Controller;

import com.example.FavouriteRestaurant.Paylods.RestaurantDto;
import com.example.FavouriteRestaurant.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    /* save a restaurant details */
    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> createPlayer(@Valid @RequestBody RestaurantDto restaurantDto){
        try {
            RestaurantDto createRestaurantDto = this.restaurantService.createRestaurant(restaurantDto);
            return new ResponseEntity<>(createRestaurantDto, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /* find restaurant details by name */
    @GetMapping("/getRestaurant/{name}")
    public ResponseEntity<RestaurantDto> getRestaurantByName(@PathVariable String name){
        try {
            return ResponseEntity.ok(this.restaurantService.findByName(name));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
