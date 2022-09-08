package com.company.models;

import com.company.exceptions.FullElevatorException;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    private final static Integer MAX_CAPACITY = 5;
    private final List<Passenger> passengers = new ArrayList<>();
    private int currentFloor;
    private boolean isDown;
    private final Building building = new Building();


    public void addPassengerToElevator(Passenger passenger) {
        if (passengers.size() < getMaxCapacity()) {
            passengers.add(passenger);
        } else {
            throw new FullElevatorException("Elevator is full");
        }
    }

    public void removePassengerFromElevator(Passenger passenger) {
        passengers.remove(passenger);
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isDown() {
        return isDown;
    }

    public void setDown(boolean down) {
        isDown = down;
    }

    public Building getBuilding() {
        return building;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public int getMaxCapacity() {
        return MAX_CAPACITY;
    }

}
