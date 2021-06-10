package com.ntiteam.task.controller;

import com.ntiteam.task.dto.MasterDto;
import com.ntiteam.task.dto.SaveMasterDto;
import com.ntiteam.task.dto.UpdateDto;
import com.ntiteam.task.service.WorldMasterService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrandMasterController {

    private final WorldMasterService worldMasterService;

    public GrandMasterController(WorldMasterService worldMasterService) {
        this.worldMasterService = worldMasterService;
    }

    @Operation(summary = "Возвращает список повелителей")
    @GetMapping({"/get/all"})
    public ResponseEntity<List<MasterDto>> getAll() {
        return ResponseEntity.ok(worldMasterService.getAll());
    }

    @Operation(summary = "Возвращает повелителей по {id}")
    @GetMapping({"/get/master/{id}"})
    public ResponseEntity<MasterDto> getMasterById(@PathVariable Long id) {
        return ResponseEntity.ok(worldMasterService.getMasterById(id));
    }

    @Operation(summary = "Создает нового повелителя с параметрами {{name}, {age}}")
    @PostMapping("/add/master")
    public ResponseEntity<String> addMaster(@RequestBody SaveMasterDto dto) {
        worldMasterService.createMaster(dto);
        return ResponseEntity.ok("New Master added");
    }

    @Operation(summary = "Назначает повелителю с {masterId} руководить планетой c {planetId}")
    @PutMapping("/edit/master")
    public ResponseEntity<String> setPlanetToMaster(@RequestBody UpdateDto dto) {
        worldMasterService.updateMasterByPlanet(dto);
        return ResponseEntity.ok("Upload!");
    }

    @Operation(summary = "Возвращает повелителей-бездельников")
    @GetMapping("/get/masters/slacker")
    public ResponseEntity<List<MasterDto>> getSlackers() {
        return ResponseEntity.ok(worldMasterService.getSlackers());
    }

    @Operation(summary = "Возвращает повелителей по старшенству, максимально 10 повелителей")
    @GetMapping("/get/masters/young")
    public ResponseEntity<List<MasterDto>> getTenYoungMasters() {
        return ResponseEntity.ok(worldMasterService.getTenYoungMasters());
    }
}
