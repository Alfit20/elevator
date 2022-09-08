package com.company.models;

import com.company.helpers.RandomGenerator;

public class Passenger {
    private Integer neededFloor;
    private Boolean isDown;

    public Passenger(int maxFloor, int currentFloor) {
        setNeededFloorForPassenger(maxFloor, currentFloor);
    }

    private void setNeededFloorForPassenger(int maxFloor, int currentFloor) {
        while (true) {
            int random = RandomGenerator.generateRandom(0, maxFloor);
            if (random != currentFloor) {
                neededFloor = random;
                break;
            }
        }
        isDown = neededFloor < currentFloor;
    }


    public Integer getNeededFloor() {
        return neededFloor;
    }

    public Boolean getDown() {
        return isDown;
    }
}
