package com.ntiteam.task.controller;

import com.ntiteam.task.model.dto.MasterDto;
import com.ntiteam.task.service.WorldMasterService;
import org.springframework.http.HttpStatus;
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
    public List<MasterDto> getAll() {
        return worldMasterService.getAll();
    }

    @GetMapping({"/get/master/{id}"})
    public MasterDto getMasterById(@PathVariable Long id) {
        return worldMasterService.getMasterById(id);
    }

    @PostMapping("/add/master/{name}/{age}")
    public ResponseEntity<?> addMaster(@PathVariable String name, @PathVariable Long age) {
        worldMasterService.createMaster(name, age);
        return new ResponseEntity("New Master " + name + ", " + age + " added", HttpStatus.OK);
    }

    @PostMapping("/edit/master/{idMaster}/{idPlanet}")
    public ResponseEntity<?> setPlanetToMaster(@PathVariable Long idPlanet, @PathVariable Long idMaster) {
        worldMasterService.updateMasterByPlanet(idPlanet, idMaster);
        return new ResponseEntity("upload!", HttpStatus.OK);
    }

    @GetMapping("/get/masters/slacker")
    public List<MasterDto> getSlackers() {
        return worldMasterService.getSlackers();
    }

    @GetMapping("/get/masters/young")
    public List<MasterDto> getTenYoungMasters() {
        return worldMasterService.getTenYoungMasters();
    }
}
