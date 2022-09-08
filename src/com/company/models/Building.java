package com.company.models;

import com.company.helpers.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private final List<Floor> floors = new ArrayList<>();

    public Building() {
        makeBuildingWithFloors();
    }

    private void makeBuildingWithFloors() {
        int buildingHeight = RandomGenerator.generateRandom(5, 16);
        for (int i = 0; i < buildingHeight; i++) {
            floors.add(new Floor(buildingHeight, i));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
