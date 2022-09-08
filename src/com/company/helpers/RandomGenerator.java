package com.company.helpers;

import java.util.Random;

public class RandomGenerator {
    public static int generateRandom(int min, int max) {
        return new Random().nextInt(max) + min;
    }
}
