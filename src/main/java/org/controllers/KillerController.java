package org.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.jpa.DragonSlayersTeam;
import org.jpa.Dragon;
import org.services.DragonSlayersTeamService;
import org.services.DragonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/killer/api")
public class KillerController {
    private final DragonSlayersTeamService dragonSlayersTeamService;
    private final DragonsService dragonsService;

    public KillerController(DragonsService dragonsService, DragonSlayersTeamService dragonSlayersTeamService) {
        this.dragonsService = dragonsService;
        this.dragonSlayersTeamService = dragonSlayersTeamService;
    }

    @GetMapping("/dragon/find-by-cave-depth/{type}")
    public ResponseEntity<Dragon> getExtremumDepthDragon(@PathVariable("type") String type,
                                                         HttpServletRequest request) {
        Dragon response_obj = dragonsService.findDeepestDragon(type);
        if (response_obj == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Dragon>(response_obj, HttpStatus.OK);
    }

    @PostMapping("/teams/create/{teamid}/{teamname}/{teamsize}/{caveid}")
    public  ResponseEntity<DragonSlayersTeam> addDragonSlayersTeam(
            @PathVariable long teamid,
            @PathVariable String teamname,
            @PathVariable long teamsize,
            @PathVariable long caveid
    ) {
        DragonSlayersTeam response_obj = dragonSlayersTeamService.createDragonSlayersTeam(
                teamid,
                teamname,
                teamsize,
                caveid
        );
        if (response_obj == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DragonSlayersTeam>(response_obj, HttpStatus.OK);
    }
}
