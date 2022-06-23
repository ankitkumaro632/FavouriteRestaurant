package com.example.FavouriteRestaurant.Controller;

import com.example.FavouriteRestaurant.Paylods.FavouriteDto;
import com.example.FavouriteRestaurant.Services.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favourite")
public class FavouriteController {
    @Autowired
    private FavouriteService favouriteService;


    /*save favourite restaurant details */
    @PostMapping("/player/{player_id}/restaurant/{restaurant_id}/add")
    public ResponseEntity<FavouriteDto> create(@RequestBody FavouriteDto favouriteDto,
                                               @PathVariable Long player_id,
                                               @PathVariable Long restaurant_id){
        try {
            FavouriteDto create = this.favouriteService.createFavouriteRestaurant(favouriteDto,player_id,restaurant_id);
            return new ResponseEntity<FavouriteDto>(create, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /* get favourite restaurant by player name */
    @GetMapping("/player/{firstName}/get")
    public ResponseEntity<List<FavouriteDto>> getFavouriteRestaurantByPlayer(@PathVariable String firstName){
        try {

            List<FavouriteDto> favouriteDtos = this.favouriteService.getFavouriteRestaurantByPlayerName(firstName);
            return new ResponseEntity<List<FavouriteDto>>(favouriteDtos,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
