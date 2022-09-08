package com.company.models;

import com.company.exceptions.FullElevatorException;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final static Integer MAX_CAPACITY = 5;
    private final List<Passenger> passengers = new ArrayList<>();
    private Integer currentFloor;
    private Boolean isDown;
    private Building building = new Building();


    public Elevator() {
        building.getFloors();
    }

    public void addPassengerToElevator(Passenger passenger) {
        if (passengers.size() > getMaxCapacity()) {
            passengers.add(passenger);
        } else {
            throw new FullElevatorException("Elevator is full");
        }
    }

    public void removePassengerFromElevator(Passenger passenger) {
        passengers.remove(passenger);
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public void setCurrentFloor(Integer currentFloor) {
        this.currentFloor = currentFloor;
    }

    public Boolean getDown() {
        return isDown;
    }

    public void setDown(Boolean down) {
        isDown = down;
    }
}
