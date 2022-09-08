package com.company;


import com.company.helpers.RandomGenerator;
import com.company.models.Building;
import com.company.models.Elevator;

public class Main {

    public static void main(String[] args) {
//        while (true) {
//            System.out.println(RandomGenerator.generateRandom(0, 11));
//        }
        Elevator elevator = new Elevator();
        System.out.println(elevator.getBuilding().getFloors());
    }
}
