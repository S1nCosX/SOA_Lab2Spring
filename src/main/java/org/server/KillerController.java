package org.server;

import jakarta.servlet.http.HttpServletRequest;
import org.Dragon.Dragon;
import org.server.services.DragonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/killer/api")
public class KillerController {
    private final DragonsService dragonsService;

    public KillerController(DragonsService dragonsService) {
        this.dragonsService = dragonsService;
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

    @PostMapping("/kill/{id}")
    public void addDragonSlayersTeam(
            @PathVariable long id
    ) {
        dragonsService.killDragon(id);
    }
}
