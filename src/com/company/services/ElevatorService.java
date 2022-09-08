package com.company.services;

import com.company.exceptions.FullFloorException;
import com.company.models.Elevator;
import com.company.models.Passenger;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ElevatorService {
    private final Elevator elevator = new Elevator();
    private int step = 1;

    public void startElevator() {
        try {
            while (true) {
                StringBuilder builder = new StringBuilder(String.format("\n***    Step %s   ***\n", step));
                builder.append(String.format("==================== Floor %s ====================\n", elevator.getCurrentFloor() + 1));
                actionOnTheFloor();
                printActions(builder);
                changeCurrentFloor();
                step++;
                Thread.sleep(800);
            }
        } catch (FullFloorException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void actionOnTheFloor() {
        Map<Boolean, List<Passenger>> map =
                elevator.getBuilding().getFloors().get(elevator.getCurrentFloor())
                        .getPassengers().stream()
                        .collect(Collectors.groupingBy(Passenger::getDown));
        addPassengersToFloor();
        if (elevator.getBuilding().getFloors().get(elevator.getCurrentFloor()).getPassengers().size() > 0) {
            addPassengersToElevator(map.get(elevator.isDown()));
        }
    }

    private void addPassengersToFloor() {
        for (int i = 0; i < elevator.getPassengers().size(); i++) {
            if (elevator.getPassengers().get(i).getNeededFloor() == elevator.getCurrentFloor()) {
                elevator.removePassengerFromElevator(elevator.getPassengers().get(i));
                elevator.getBuilding().getFloors().get(elevator.getCurrentFloor()).addPassengerToFloor(new Passenger(
                        elevator.getBuilding().getFloors().size(), elevator.getCurrentFloor()
                ));
                i--;
            }
        }
    }

    private void addPassengersToElevator(List<Passenger> passengers) {
        int size = passengers != null ? passengers.size() : 0;
        for (int i = 0; i < size; i++) {
            if ((elevator.getMaxCapacity() - elevator.getPassengers().size()) > i) {
                elevator.addPassengerToElevator(passengers.get(i));
                elevator.getBuilding().getFloors()
                        .get(elevator.getCurrentFloor()).removePassengerFromFloor(passengers.get(i));
            }
        }
    }

    private void printActions(StringBuilder builder) {
        builder.append("|");
        for (int i = 0; i < elevator.getMaxCapacity(); i++) {
            if (elevator.getPassengers().size() > i) {
                builder.append("_").append(elevator.getPassengers().get(i).getNeededFloor() + 1);
            } else {
                builder.append('_');
            }
        }
        builder.append("_|\n");
        System.out.println(builder);
    }

    private void changeCurrentFloor() {
        if (elevator.getCurrentFloor() < elevator.getBuilding().getFloors().size() - 1
                && !elevator.isDown()) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
        }
        if (elevator.getCurrentFloor() > 0 && elevator.isDown()) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        }
        if (elevator.getCurrentFloor() == elevator.getBuilding().getFloors().size() - 1 || elevator.getCurrentFloor() == 0) {
            changeDirection();
        }
    }

    private void changeDirection() {
        boolean passengersForward = elevator.getBuilding().getFloors().get(elevator.getCurrentFloor()).getPassengers()
                .stream()
                .anyMatch(e -> e.getDown() == elevator.isDown());
        if (elevator.getPassengers().isEmpty() && !passengersForward) {
            elevator.setDown(!elevator.isDown());
        }
    }
}
