package com.company.models;

import com.company.helpers.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Floor> floors = new ArrayList<>();

    public Building() {
        makeBuildingWithFloors();
    }

    public void makeBuildingWithFloors() {
        int buildingHeight = RandomGenerator.generateRandom(5, 16);
        for (int i = 0; i < buildingHeight; i++) {
            floors.add(new Floor(buildingHeight, i));
        }
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
