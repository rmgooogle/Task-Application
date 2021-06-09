package com.ntiteam.task.controller;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.SaveMasterDto;
import com.ntiteam.task.dto.UpdateDto;
import com.ntiteam.task.service.WorldMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add/master")
    public ResponseEntity<String> addMaster(@RequestBody SaveMasterDto dto) {
        worldMasterService.createMaster(dto);
        return ResponseEntity.ok("New Master added");
    }

    @PostMapping("/edit/master")
    public ResponseEntity<String> setPlanetToMaster(@RequestBody UpdateDto dto) {
        worldMasterService.updateMasterByPlanet(dto);
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
