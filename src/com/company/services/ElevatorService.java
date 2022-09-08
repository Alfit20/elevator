package com.company.services;

import com.company.models.Elevator;
import com.company.models.Passenger;

import java.util.List;

public class ElevatorService {
    private final Elevator elevator = new Elevator();
    private Integer step;


    public void startElevator() {
        StringBuilder builder = new StringBuilder(String.format("***    Step %s   ***", ++step));
        builder.append(String.format("====================Floor %s ====================", elevator.getCurrentFloor() + 1));
    }

    public void addPassengersToFloor() {
        for (int i = 0; i < elevator.getPassengers().size(); i++) {
            if (elevator.getPassengers().get(i).getNeededFloor() == elevator.getCurrentFloor()) {
                elevator.removePassengerFromElevator(elevator.getPassengers().get(i));
                elevator.getBuilding().getFloors().get(elevator.getCurrentFloor()).addPassengerToFloor(new Passenger(
                        elevator.getBuilding().getFloors().size(), elevator.getCurrentFloor()
                ));
            }
        }
    }

    public void addPassengersToElevator(List<Passenger> passengers) {
        int size = passengers != null ? passengers.size() : 0;
        for (int i = 0; i < size; i++) {
            if ((elevator.getMaxCapacity() - elevator.getPassengers().size()) > i) {
                elevator.addPassengerToElevator(passengers.get(i));
                elevator.getBuilding().getFloors().get(elevator.getCurrentFloor()).removePassengerFromFloor(passengers.get(i));
            }
        }
    }

}
