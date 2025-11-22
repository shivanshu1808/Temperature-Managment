package com.building.control.controller;

import com.building.control.model.Apartment;
import com.building.control.model.Building;
import com.building.control.model.CommonRoom;
import com.building.control.service.BuildingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
@CrossOrigin(origins = "*")
public class BuildingController {

    private final BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        this.buildingService = buildingService;
    }


    @PostMapping("/create")
    public Building createInitialBuilding() {
        return buildingService.createInitialBuilding();
    }

    @GetMapping("/{id}")
    public Building getBuilding(@PathVariable Long id) {
        return buildingService.getBuilding(id);
    }


    @PutMapping("/{id}/temperature")
    public Building updateTemperature(
            @PathVariable Long id,
            @RequestParam double newTemperature
    ) {
        return buildingService.updateBuildingTemperature(id, newTemperature);
    }


    @PostMapping("/{id}/add-apartment")
    public Building addApartment(
            @PathVariable Long id,
            @RequestBody Apartment apartment
    ) {
        return buildingService.addApartment(id, apartment);
    }


    @PostMapping("/{id}/add-common-room")
    public Building addCommonRoom(
            @PathVariable Long id,
            @RequestBody CommonRoom room
    ) {
        return buildingService.addCommonRoom(id, room);
    }
}
