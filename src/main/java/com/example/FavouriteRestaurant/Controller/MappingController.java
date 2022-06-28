package com.example.FavouriteRestaurant.Controller;

import com.example.FavouriteRestaurant.Paylods.MappingDto;
import com.example.FavouriteRestaurant.Services.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mapping")
public class MappingController {

    @Autowired
    private MappingService mappingService;

    /* create and save  restaurant details */
    @PostMapping("/player/{player_id}/restaurant/{restaurant_id}/addMapping")
    public ResponseEntity<MappingDto> create(@RequestBody MappingDto mappingDto,
                                             @PathVariable Long player_id,
                                             @PathVariable Long restaurant_id){
        try {
            MappingDto create = this.mappingService.saveMapping(mappingDto,player_id,restaurant_id);
            return new ResponseEntity<MappingDto>(create, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* get favourite restaurant by player name */
    @GetMapping("/player/{firstName}/get")
    public ResponseEntity<List<MappingDto>> getRestaurantByPlayer(@PathVariable String firstName){
        try {

            List<MappingDto> mappingDtos = this.mappingService.findMapping(firstName);
            return new ResponseEntity<List<MappingDto>>(mappingDtos,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    /* find the all player above 60 by restaurant name */
    @GetMapping("/restaurant/{name}/player/{age}")
    public ResponseEntity<List<MappingDto>> getAllPlayerByRestaurantNameAndPlayerAge(@PathVariable String name,
                                                                        @PathVariable int age){
        try {
            List<MappingDto> mappingDtos = this.mappingService.getAllPlayerByRestaurantNameAndPlayerAge(name, age);
            return new ResponseEntity<List<MappingDto>>(mappingDtos,HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
