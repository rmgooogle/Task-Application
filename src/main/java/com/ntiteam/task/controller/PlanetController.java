package com.ntiteam.task.controller;

import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.service.WorldMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanetController {

    private final WorldMasterService worldMasterService;

    public PlanetController(WorldMasterService worldMasterService) {
        this.worldMasterService = worldMasterService;
    }

    @GetMapping({"/get/planet/{id}"})
    public ResponseEntity<PlanetDto> getPlanetById(@PathVariable Long id) {
        return ResponseEntity.ok(worldMasterService.getPlanetById(id));
    }

    @PostMapping(value = "/add/planet/{name}")
    public ResponseEntity<String> createPlanet(@PathVariable String name) {
        worldMasterService.createPlanet(name);
        return ResponseEntity.ok("Created");
    }

    @DeleteMapping({"/delete/planet/{id}"})
    public ResponseEntity<String> deletePlanetById(@PathVariable Long id) {
        worldMasterService.deletePlanetById(id);
        return ResponseEntity.ok("Deleted");
    }
}
