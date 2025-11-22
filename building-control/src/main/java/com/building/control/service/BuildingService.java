package com.building.control.service;

import com.building.control.model.*;
import com.building.control.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuildingService {

    private final BuildingRepository buildingRepository;
    private final ApartmentRepository apartmentRepository;
    private final CommonRoomRepository commonRoomRepository;

    public BuildingService(BuildingRepository buildingRepository,
                           ApartmentRepository apartmentRepository,
                           CommonRoomRepository commonRoomRepository) {
        this.buildingRepository = buildingRepository;
        this.apartmentRepository = apartmentRepository;
        this.commonRoomRepository = commonRoomRepository;
    }


    public Building createInitialBuilding() {

        Building building = new Building();
        building.updateRequestedTemperature(25.0);


        Apartment a1 = new Apartment("101", "Owner-101");
        Apartment a2 = new Apartment("102", "Owner-102");


        CommonRoom gym = new CommonRoom("Gym");
        CommonRoom library = new CommonRoom("Library");


        building.addApartment(a1);
        building.addApartment(a2);
        building.addCommonRoom(gym);
        building.addCommonRoom(library);


        applyTemperatureLogic(building);

        return buildingRepository.save(building);
    }


    public Building updateBuildingTemperature(Long buildingId, double newTemp) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found"));

        building.updateRequestedTemperature(newTemp);
        applyTemperatureLogic(building);

        return buildingRepository.save(building);
    }


    public Building addApartment(Long buildingId, Apartment apartment) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found"));

        apartmentRepository.save(apartment);
        building.addApartment(apartment);

        applyTemperatureLogic(building);

        return buildingRepository.save(building);
    }


    public Building addCommonRoom(Long buildingId, CommonRoom commonRoom) {
        Building building = buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found"));

        commonRoomRepository.save(commonRoom);
        building.addCommonRoom(commonRoom);

        applyTemperatureLogic(building);

        return buildingRepository.save(building);
    }


    private void applyTemperatureLogic(Building building) {
        double reqTemp = building.getRequestedTemperature();


        for (Apartment apartment : building.getApartments()) {
            apartment.updateRoomStatus(reqTemp);
        }


        for (CommonRoom c : building.getCommonRooms()) {
            c.updateRoomStatus(reqTemp);
        }
    }


    public Building getBuilding(Long buildingId) {
        return buildingRepository.findById(buildingId)
                .orElseThrow(() -> new RuntimeException("Building not found"));
    }
}
