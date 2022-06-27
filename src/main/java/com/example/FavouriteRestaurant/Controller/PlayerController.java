package com.example.FavouriteRestaurant.Controller;

import com.example.FavouriteRestaurant.Paylods.PlayerDto;
import com.example.FavouriteRestaurant.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    /* save the details of Player*/
    @PostMapping("/addPlayer")
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto){
        try {
            PlayerDto createPlayerDto = this.playerService.createPlayer(playerDto);
            return new ResponseEntity<>(createPlayerDto, HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    /* find the player by name*/
    @GetMapping("/getPlayer/{firstName}/{lastName}")
    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String firstName,
                                                     @PathVariable String lastName){
        try {
            return ResponseEntity.ok(this.playerService.getPlayerByName(firstName,lastName));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
