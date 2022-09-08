package com.company.models;

import com.company.exceptions.FullFloorException;
import com.company.helpers.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final List<Passenger> passengers = new ArrayList<>();

    public Floor(int buildingHeight, int numFloor) {
        generatePassengers(buildingHeight, numFloor);
    }

    private void generatePassengers(int buildingHeight, int numFloor) {
        for (int i = 0; i <= RandomGenerator.generateRandom(0, 11); i++) {
            passengers.add(new Passenger(buildingHeight, numFloor));
        }
    }

    public void addPassengerToFloor(Passenger passenger) {
        if (passengers.size() <= 10) {
            passengers.add(passenger);
        } else {
            throw new FullFloorException("Floor is full");
        }
    }

    public void removePassengerFromFloor(Passenger passenger) {
        if (passengers.size() > 0) {
            passengers.remove(passenger);
        }
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

}
