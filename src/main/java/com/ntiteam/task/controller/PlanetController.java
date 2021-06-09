package com.ntiteam.task.controller;

import com.ntiteam.task.dto.PlanetDto;
import com.ntiteam.task.service.WorldMasterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlanetController {

    private final WorldMasterService worldMasterService;

    public PlanetController(WorldMasterService worldMasterService) {
        this.worldMasterService = worldMasterService;
    }

    @Operation(summary = "Возвращает планету по {id}")
    @GetMapping({"/get/planet/{id}"})
    public ResponseEntity<PlanetDto> getPlanetById(@PathVariable Long id) {
        return ResponseEntity.ok(worldMasterService.getPlanetById(id));
    }

    @Operation(summary = "Создает планету с именем {name}")
    @PostMapping(value = "/add/planet/{name}")
    public ResponseEntity<String> createPlanet(@PathVariable String name) {
        worldMasterService.createPlanet(name);
        return ResponseEntity.ok("Created");
    }

    @Operation(summary = "Удаляет планету по {id}")
    @DeleteMapping({"/delete/planet/{id}"})
    public ResponseEntity<String> deletePlanetById(@PathVariable Long id) {
        worldMasterService.deletePlanetById(id);
        return ResponseEntity.ok("Deleted");
    }
}
