package com.ntiteam.task.controller;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.service.WorldMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrandMasterController {

    private final WorldMasterService worldMasterService;

    public GrandMasterController(WorldMasterService worldMasterService) {
        this.worldMasterService = worldMasterService;
    }

    @GetMapping({"/get/all"})
    public ResponseEntity<List<MasterDto>> getAll() {
        return ResponseEntity.ok(worldMasterService.getAll());
    }

    @GetMapping({"/get/master/{id}"})
    public ResponseEntity<MasterDto> getMasterById(@PathVariable Long id) {
        return ResponseEntity.ok(worldMasterService.getMasterById(id));
    }

    @PostMapping("/add/master/{name}/{age}")
    public ResponseEntity<String> addMaster(@PathVariable String name, @PathVariable Long age) {
        worldMasterService.createMaster(name, age);
        return ResponseEntity.ok("New Master " + name + ", " + age + " added");
    }

    @PostMapping("/edit/master/{idMaster}/{idPlanet}")
    public ResponseEntity<String> setPlanetToMaster(@PathVariable Long idPlanet, @PathVariable Long idMaster) {
        worldMasterService.updateMasterByPlanet(idPlanet, idMaster);
        return ResponseEntity.ok("Upload!");
    }

    @GetMapping("/get/masters/slacker")
    public ResponseEntity<List<MasterDto>> getSlackers() {
        return ResponseEntity.ok(worldMasterService.getSlackers());
    }

    @GetMapping("/get/masters/young")
    public ResponseEntity<List<MasterDto>> getTenYoungMasters() {
        return ResponseEntity.ok(worldMasterService.getTenYoungMasters());
    }
}
