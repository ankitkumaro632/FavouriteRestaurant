package com.example.FavouriteRestaurant.Controller;

import com.example.FavouriteRestaurant.Paylods.FavouriteDto;
import com.example.FavouriteRestaurant.Paylods.RestaurantDto;
import com.example.FavouriteRestaurant.Services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    /* save a restaurant details */
    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> createPlayer(@RequestBody RestaurantDto restaurantDto){
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

    /* get favourite restaurant by player name */
    @GetMapping("/player/{firstName}/get")
    public ResponseEntity<List<RestaurantDto>> getRestaurantByPlayer(@PathVariable String firstName){
        try {
            List<RestaurantDto> restaurantDtos = this.restaurantService.getRestaurantAndPlayerDetails(firstName);
            return new ResponseEntity<List<RestaurantDto>>(restaurantDtos,HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}