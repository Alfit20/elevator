package com.company.models;

import com.company.helpers.RandomGenerator;

public class Passenger {
    private final Integer neededFloor;
    private final Boolean isDown;

    public Passenger(int maxFloor, int currentFloor) {
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
